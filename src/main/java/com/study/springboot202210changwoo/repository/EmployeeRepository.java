package com.study.springboot202210changwoo.repository;

import com.study.springboot202210changwoo.web.dto.CategoryDto;
import com.study.springboot202210changwoo.web.dto.EmpDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeRepository {

    public int saveEmployee(EmpDto empDto);
    public EmpDto findEmployeeByEmpId(int empId);

    public int modifyEmployee(EmpDto empDto);
}

