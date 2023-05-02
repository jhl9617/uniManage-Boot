package org.webMonster.uniManageBoot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.webMonster.uniManageBoot.common.interceptor.LoginCheckInterceptor;

import java.io.IOException;
import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public LoginCheckInterceptor loginCheckInterceptor() {
        return new LoginCheckInterceptor();
    }

    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        SortHandlerMethodArgumentResolver sortArgumentResolver = new SortHandlerMethodArgumentResolver();
        sortArgumentResolver.setSortParameter("sortBy");
        sortArgumentResolver.setPropertyDelimiter("-");
        PageableHandlerMethodArgumentResolver pageableArgumentResolver = new PageableHandlerMethodArgumentResolver(sortArgumentResolver);
        pageableArgumentResolver.setOneIndexedParameters(true);
        pageableArgumentResolver.setMaxPageSize(500);
        pageableArgumentResolver.setFallbackPageable(PageRequest.of(0, 10));
        argumentResolvers.add(pageableArgumentResolver);
    }

    //새로고침 시 404 에러 해결
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .resourceChain(true)
                .addResolver(new PathResourceResolver() {
                    @Override
                    protected Resource getResource(String resourcePath, Resource location) throws IOException {
                        Resource requestedResource = location.createRelative(resourcePath);
                        return requestedResource.exists() && requestedResource.isReadable() ? requestedResource
                                : new ClassPathResource("/static/index.html");
                    }
                });
    }

    //로그인 체크 인터셉터
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginCheckInterceptor loginCheckInterceptor =
                (LoginCheckInterceptor) applicationContext.getBean("loginCheckInterceptor");
        registry.addInterceptor(loginCheckInterceptor)
                .excludePathPatterns("/")
                .excludePathPatterns("/login")
                .excludePathPatterns("/login/**");
    }


}