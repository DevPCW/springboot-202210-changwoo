package com.study.springboot202210changwoo.web.controller;


import com.study.springboot202210changwoo.service.OptionService;
import com.study.springboot202210changwoo.service.UserService;
import com.study.springboot202210changwoo.web.dto.CategoryDto;
import com.study.springboot202210changwoo.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/option")
public class OptionController {


    @Autowired
    private OptionService optionService;


    @PostMapping("/category/newcate")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto) {
        System.out.println(categoryDto);
        int categoryId = optionService.addCategory(categoryDto);

//        return ResponseEntity.created(URI.create("/api/option/category/" + optionService.addCategory(categoryDto)))
//        .body(categoryDto);
        // 자동으로 'Headers' 에 'Location' 까지 생성됨

        return ResponseEntity.created(URI.create("/api/option/category/newcate/" + categoryId))
                .body(categoryDto);
    }



    @GetMapping("/categories")
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok(optionService.getCategoryList());
    }

    @PutMapping("/category/{categoryId}")
    public ResponseEntity<?> modifyCategory(@PathVariable int categoryId, @RequestBody CategoryDto categoryDto) {
        optionService.modifyCategory(categoryId, categoryDto);
        return ResponseEntity.ok(true);
    }
}
