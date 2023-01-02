package com.study.springboot202210changwoo.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 실행될 때
@Target({ElementType.TYPE, ElementType.METHOD}) // TYPE -> 클래스를 의미 METHOD -> 메소드를 의미: <이 어노테이션은 어디에서 쓰겠는가(클래스 위에 또는 메소드 위에도 가능)>
public @interface PrintTestAspect {

}
