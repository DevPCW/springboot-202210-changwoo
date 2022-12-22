package com.study.springboot202210changwoo.web.controller;

import com.study.springboot202210changwoo.service.EmployeeService;
import com.study.springboot202210changwoo.service.OptionService;
import com.study.springboot202210changwoo.web.dto.CMRespDto;
import com.study.springboot202210changwoo.web.dto.CategoryDto;
import com.study.springboot202210changwoo.web.dto.EmpDto;
import com.study.springboot202210changwoo.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/newemp")
    public ResponseEntity<?> addEmployee(@RequestBody EmpDto empDto) {
        System.out.println(empDto);
        int empId = employeeService.addEmployee(empDto);

        return ResponseEntity.created(null).body(new CMRespDto<>("직원등록완료", employeeService.addEmployee(empDto)));
    }

    @GetMapping("/newemp/{empId}") // 유저 조회
    public ResponseEntity<?> getEmployee(@PathVariable int empId) {
        EmpDto empDto = employeeService.getEmployee(empId);
        return ResponseEntity.ok().body(empDto);
    }

    @PutMapping("/newemp/{empId}")
    public ResponseEntity<?> modifyEmployee(@PathVariable int empId, @RequestBody EmpDto empDto) {
        employeeService.modifyEmployee(empId, empDto);
        return ResponseEntity.ok(true);
    }

}
