package com.study.springboot202210changwoo.web.controller;

import com.study.springboot202210changwoo.service.UserService;
import com.study.springboot202210changwoo.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/db/test")
public class DBTestController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
        return ResponseEntity.created(null).body(true);
    }

    @GetMapping("/user/{userId}") // 유저 조회
    public ResponseEntity<?> getUser(@PathVariable int userId) {
        UserDto userDto = userService.getUser(userId);
        return ResponseEntity.ok().body(null);
    }
}
