package com.study.springboot202210changwoo.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller1 {

//    @RequestMapping(value = "/page1", method = RequestMethod/GET) 얘를 줄인게 겟맵핑

    @GetMapping("/page1")
    public String page1() {
        return "page1"; // 얘는 html 파일 이름임
    }

    @GetMapping("/page2")
    public String page2() {
        return "page2"; // 얘는 html 파일 이름임
    }
}
