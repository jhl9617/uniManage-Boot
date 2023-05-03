package org.webMonster.uniManageBoot.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    // Define a pointcut to match the execution of global functions
    @Pointcut("execution(* org.webMonster.uniManageBoot..*.*(..))")
    public void globalFunctions() {}

    // Log before the method execution
    @Before("globalFunctions()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Executing: {} with arguments: {}", joinPoint.getSignature().toShortString(), joinPoint.getArgs());
    }

    // Log after the method execution
    @AfterReturning(pointcut = "globalFunctions()", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        log.info("Executed: {} with result: {}", joinPoint.getSignature().toShortString(), result);
    }
}
