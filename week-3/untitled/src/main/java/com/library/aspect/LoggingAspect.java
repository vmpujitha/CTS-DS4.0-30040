package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Around("execution(* com.library.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("[LOG] Method " + joinPoint.getSignature() + " is starting...");
        Object result = joinPoint.proceed();
        System.out.println("[LOG] Method " + joinPoint.getSignature() + " finished.");
        System.out.println("[LOG] Execution time: " + (System.currentTimeMillis() - start) + " ms");
        return result;
    }
}
