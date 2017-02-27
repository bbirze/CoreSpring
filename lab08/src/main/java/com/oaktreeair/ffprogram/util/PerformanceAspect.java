package com.oaktreeair.ffprogram.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {
	
	@Pointcut("execution(int calcBonus(..))")
	public void myPointcut()  {}
	
	
	@Around("myPointcut()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long startTime = System.currentTimeMillis();
		Object o = joinPoint.proceed();
		long endTime = System.currentTimeMillis();
		
		System.out.println("calcBonus elapsed time: " + (endTime - startTime) 
							+ " milliseconds");
		return o;
	}

}
