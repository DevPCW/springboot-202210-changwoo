package com.study.springboot202210changwoo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class ParamsAop {
    @Pointcut("@annotation(com.study.springboot202210changwoo.aop.annotation.ParamsAspect)")
    private void signaturePointCut() {}

    @Around("signaturePointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        CodeSignature codeSignature = (CodeSignature) proceedingJoinPoint.getSignature();
        String className = codeSignature.getDeclaringTypeName();
        String methodName = codeSignature.getName();

        String[] argNames = codeSignature.getParameterNames(); // 'CodeSignature' 로 다운캐스팅해야 쓸 수 있음.
        Object[] args = proceedingJoinPoint.getArgs();

        for(int i = 0; i < argNames.length; i++) {
            log.info("Params >> {}.{}({}): {}", className, methodName, argNames[i], args[i]);
        }

        Object returnValue = proceedingJoinPoint.proceed();

        return returnValue;
    }
}
