package com.study.springboot202210changwoo.web.controller.account;

import com.study.springboot202210changwoo.service.UserService;
import com.study.springboot202210changwoo.web.dto.CMRespDto;
import com.study.springboot202210changwoo.web.dto.UserDto;
import com.study.springboot202210changwoo.web.dto.UsernameDto;
import com.study.springboot202210changwoo.web.exception.CustomTestException;
import com.study.springboot202210changwoo.web.exception.CustomValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    @Autowired
    private UserService userService;
//    @NotBlank(message = "사용자 이름을 입력하세요.") String username
    // ^ -> 정규식 시작
    // a-zA-Z -> 영어 전체
    // \\d -> 숫자 전체
    // $ -> 정규식 끝
    // {5,20} -> 아이디 최소 최대 글자 개수 (중괄호 안 공백 포함하면안됨)
    
    @GetMapping("/username") 
    public ResponseEntity<?> duplicateUsername(@Valid UsernameDto usernameDto, BindingResult bindingResult) { // 중복확인
//        System.out.println(userDto);
//        System.out.println(bindingResult.getErrorCount());
//        System.out.println(bindingResult.getFieldErrors());
//        System.out.println(bindingResult.hasErrors());

//        if(bindingResult.hasErrors()) {
//            Map<String, String> errorMap = new HashMap<>();
//            bindingResult.getFieldErrors().forEach(error -> {
//                errorMap.put(error.getField(), error.getDefaultMessage());
//            });
////            errorMap.forEach((k, v) -> {
////                System.out.println(k + ": " + v);
////            });
//            throw new CustomValidException(errorMap);
//        }
        userService.duplicateUsername(usernameDto.getUsername());
        return ResponseEntity.ok().body(new CMRespDto<>("가입가능한 사용자이름", true));
    }

    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {
//        if(bindingResult.hasErrors()) {
//            Map<String, String> errorMap = new HashMap<>();
//            bindingResult.getFieldErrors().forEach(error -> {
//                errorMap.put(error.getField(), error.getDefaultMessage());
//                System.out.println(errorMap.get(error.getField()));
//            });
//
//            throw new CustomValidException(errorMap);
//        }

        return ResponseEntity
                .created(URI.create("/account/login"))
                .body(new CMRespDto<>("회원가입 완료", null));
    }
}
