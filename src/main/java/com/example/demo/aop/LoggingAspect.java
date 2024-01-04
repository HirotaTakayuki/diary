package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
/**
 * https://misc-room.com/spring-booy-aop-logging/
 */
public class LoggingAspect {

  @Around("execution(* com.example.demo..*(..))")
  public Object logging(ProceedingJoinPoint pjp) throws Throwable {
    try {
      String methodName =
          pjp.getSignature().getDeclaringType().getSimpleName() + "#" + pjp.getSignature()
              .getName();

      log.info("start " + methodName);
      Object obj = pjp.proceed();
      log.info("finish " + methodName);

      return obj;
    } catch (Throwable e) {
      log.error(e.getMessage());
      throw e;
    }

  }
}