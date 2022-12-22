package com.study.springboot202210changwoo.service;

import com.study.springboot202210changwoo.repository.EmployeeRepository;
import com.study.springboot202210changwoo.repository.OptionRepository;
import com.study.springboot202210changwoo.web.dto.CategoryDto;
import com.study.springboot202210changwoo.web.dto.EmpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public int addEmployee(EmpDto empDto) {
        // return employeeRepository.saveEmployee(empDto) > 0 ? empDto.getEmpId() : 0;
        System.out.println("데이터베이스에 insert 전: " + empDto.getEmpId());
        employeeRepository.saveEmployee(empDto);
        System.out.println("데이터베이스에 insert 후: " + empDto.getEmpId());
        return empDto.getEmpId();
    }

    public EmpDto getEmployee(int empId) {
        EmpDto empDto = null;
        empDto = employeeRepository.findEmployeeByEmpId(empId);
        return empDto;
    }

    public void modifyEmployee(int empId, EmpDto empDto) {
        empDto.setEmpId(empId);
        employeeRepository.modifyEmployee(empDto);
    }


}
