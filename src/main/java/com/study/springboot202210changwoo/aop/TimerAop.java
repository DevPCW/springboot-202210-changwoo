package com.study.springboot202210changwoo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class TimerAop {
    @Pointcut("@annotation(com.study.springboot202210changwoo.aop.annotation.TimerAspect)")
    private void timerPointCut() {}

    @Around("timerPointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {


       StopWatch stopWatch = new StopWatch();
       stopWatch.start();



        Object returnValue = proceedingJoinPoint.proceed();

        stopWatch.stop();
        String className = proceedingJoinPoint.getSignature().getDeclaringTypeName(); // 클래스 명
        String methodName = proceedingJoinPoint.getSignature().getName(); // 메소드 명

//        log.info("Class >> {}, Method >> {}: {}초", className, methodName, stopWatch.getTotalTimeSeconds());
        log.error("Class >> {}, Method >> {}: {}초", className, methodName, stopWatch.getTotalTimeSeconds());

//        System.out.println("메소드 실행 시간: " + stopWatch.getTotalTimeSeconds() + "초");

        return returnValue;
    }
}
