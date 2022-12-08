package com.study.springboot202210changwoo.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 상위 객체가 컨트롤러고 하위에 컨트롤러, 서비스, 레파지토리, 컨피귤러가 있음
public class StudentController {
    @Autowired // 변수명을 찾아오는게 아니고, 타입을 찾아옴
    private StudentService studentService; // 여기에 주입이 되야함 그러려면 IoC에 등록이 되어야 하는데,
    // 'StudentServiceImpl' 에 'Component' 를 달아주고 바로 위  주입이 될 코드에 '@Autowired' 를 달아줘야한다.

    @Autowired
    private Test1 t1;

    @Autowired
    private Test2 t2;

    @ResponseBody
    @GetMapping("/student")
    public String printStudent() {

        Student student = Student.builder()
                .studentId(2001)
                .studentName("김경민")
                .build();

        t1.print();
        t2.print();

        studentService.printStudentInfo(student);

        return null;
    }
}
