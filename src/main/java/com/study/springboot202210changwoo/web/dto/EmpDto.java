package com.study.springboot202210changwoo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpDto {
    private int empId;
    private String empName;
    private int empAge;
    private String empPhone;
}
