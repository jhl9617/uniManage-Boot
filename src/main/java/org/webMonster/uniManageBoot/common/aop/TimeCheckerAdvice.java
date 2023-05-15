package org.webMonster.uniManageBoot.common.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.webMonster.uniManageBoot.common.domain.PerformanceLog;
import org.webMonster.uniManageBoot.common.service.PerformanceLogService;

import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class TimeCheckerAdvice {

	@Autowired
	private PerformanceLogService service;

	@Around("execution(* org.webMonster.uniManageBoot.*Service*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {

		long startTime = System.currentTimeMillis();
		log.info(Arrays.toString(pjp.getArgs()));
		
		Signature signature = pjp.getSignature();
		Object target = pjp.getTarget();
		
		String signatureName = signature.getName();
		String signatureDeclaringTypeName = signature.getDeclaringTypeName();
		
		log.info("signature.getName() = " + signatureName);
		log.info("signature.getDeclaringTypeName() = " + signatureDeclaringTypeName);
		log.info("target = " + target);

		Object result = pjp.proceed();

		long endTime = System.currentTimeMillis();
		
		long durationTime = endTime - startTime;
		
		log.info(pjp.getSignature().getName() + " : " + durationTime);
		
		PerformanceLog performanceLog = new PerformanceLog();
		performanceLog.setSignatureName(signatureName);
		performanceLog.setSignatureTypeName(signatureDeclaringTypeName);
		performanceLog.setDurationTime(durationTime);
		
		service.register(performanceLog);
		
		return result;
	}

}
