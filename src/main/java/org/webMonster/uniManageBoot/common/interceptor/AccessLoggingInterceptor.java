package org.webMonster.uniManageBoot.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.webMonster.uniManageBoot.common.domain.AccessLog;
import org.webMonster.uniManageBoot.common.service.AccessLogService;
import org.webMonster.uniManageBoot.common.util.NetUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Slf4j
public class AccessLoggingInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private AccessLogService service;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		String requestUri = request.getRequestURI();
		
		String remoteAddr = NetUtils.getIp(request);
		
		log.info("requestURL : " + requestUri);
		log.info("remoteAddr : " + remoteAddr);
		
		if(handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			
			Class<?> clazz = method.getDeclaringClass();
			
			String className = clazz.getName();
			String classSimpleName = clazz.getSimpleName();
			String methodName = method.getName();

			log.info("[ACCESS CONTROLLER] " + className + "." + methodName);
			
			AccessLog accessLog = new AccessLog();
			
			accessLog.setRequestUri(requestUri);
			accessLog.setRemoteAddr(remoteAddr);
			accessLog.setClassName(className);
			accessLog.setClassSimpleName(classSimpleName);
			accessLog.setMethodName(methodName);
			
			service.register(accessLog);
		}
		else {
			log.info("handler : " + handler);
		}
		
	}
	
}
