package com.study.springboot202210changwoo.web.controller.account;

import com.study.springboot202210changwoo.service.UserService;
import com.study.springboot202210changwoo.web.dto.CMRespDto;
import com.study.springboot202210changwoo.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;


@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    @Autowired
    private UserService userService;

    @GetMapping("/username")
    public ResponseEntity<?> duplicateUsername(String username) { // 중복확인
        System.out.println(username);
        userService.duplicateUsername(username);
        return ResponseEntity.ok().body(new CMRespDto<>("가입가능한 사용자이름", true));
    }

    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        System.out.println(userDto);
        return ResponseEntity
                .created(URI.create("/account/login"))
                .body(new CMRespDto<>("회원가입 완료", null));
    }
}