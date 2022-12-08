package com.study.springboot202210changwoo.IocAndDi;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService { // 이게(StudentServiceImpl) 구현 객체임 ㅇㅇ

    @Override
    public void printStudentInfo(Student student) {

        System.out.println("학번: " + student.getStudentId());
        System.out.println("이름: " + student.getStudentName());
    }
}
