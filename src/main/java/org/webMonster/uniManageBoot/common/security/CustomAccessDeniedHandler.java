package org.webMonster.uniManageBoot.common.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.webMonster.uniManageBoot.common.exception.ApiErrorInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
	
	@Autowired
	private MessageSource messageSource;	

    @Override
    public void handle(HttpServletRequest req,
    		HttpServletResponse res,
    		AccessDeniedException accessDeniedException) throws IOException, ServletException {
    	log.info("handle");
    	
    	String message = messageSource.getMessage("common.accessDenied", null, Locale.KOREAN);
    	
    	ApiErrorInfo apiErrorInfo = new ApiErrorInfo();
    	apiErrorInfo.setMessage(message);

    	ObjectMapper mapper = new ObjectMapper();
    	
    	String jsonString = mapper.writeValueAsString(apiErrorInfo);
    	
    	res.setContentType("application/json;charset=UTF-8");
    	res.setStatus(HttpStatus.FORBIDDEN.value());
    	res.getWriter().write(jsonString);
    }
    
}
