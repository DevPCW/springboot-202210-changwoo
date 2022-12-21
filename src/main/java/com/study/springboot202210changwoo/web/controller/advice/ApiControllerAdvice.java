package com.study.springboot202210changwoo.web.controller.advice;


import com.study.springboot202210changwoo.web.dto.CMRespDto;
import com.study.springboot202210changwoo.web.exception.CustomTestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice // 간단한 예시임
public class ApiControllerAdvice { // 예외를 응답해서 낚아채는 녀석

    @ExceptionHandler(CustomTestException.class) //  = 'catch' 에 해당되는 부분 // RestController1 에서의 예외 터지고 그다음 실행문 실행안되고 낚아채서 이쪽으로 오게됨.
    public ResponseEntity<?> testException(CustomTestException e) {
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), e.getErrorMap())); // 유효성검사 실패, 'Map' 이니깐 제이슨 형태로 자동 파싱
    }
}
