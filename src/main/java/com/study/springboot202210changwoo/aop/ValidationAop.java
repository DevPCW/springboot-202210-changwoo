package com.study.springboot202210changwoo.aop;

import com.study.springboot202210changwoo.web.exception.CustomValidException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component // 'AOP' 는 항상 'IoC' 에 등록이 되어있어야함.
public class ValidationAop {

    @Pointcut("execution(* com.study.springboot202210changwoo.web.controller.account.AccountApiController.*(..))")
    private void executionPointCut() {}

    @Around("executionPointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable { // validation은 메소드가 실행되기 전에 해야 하는데, around 메소드는 전과 후 둘 다
        Object[] args = proceedingJoinPoint.getArgs();

        System.out.println("AOP 작동함!!");

        BeanPropertyBindingResult bindingResult = null;
        for(Object arg : args) {
            if(arg.getClass() == BeanPropertyBindingResult.class){
                bindingResult = (BeanPropertyBindingResult) arg;
                break;
            }
        }

        if(bindingResult != null) {
            if(bindingResult.hasErrors()) {
                Map<String, String> errorMap = new HashMap<>();
                bindingResult.getFieldErrors().forEach(error -> {
                    errorMap.put(error.getField(), error.getDefaultMessage());
                    System.out.println(errorMap.get(error.getField()));
                });

                throw new CustomValidException(errorMap);
            }
        }

        // 메소드 호출 전 처리
        Object returnValue = proceedingJoinPoint.proceed(); // 얘가 기준점임 proceed() -> 우리가 지정한 메소드 실행될 메소드(비지니스 로직)
        // 메소드 호출 후 처리

        return returnValue;
    }

}
