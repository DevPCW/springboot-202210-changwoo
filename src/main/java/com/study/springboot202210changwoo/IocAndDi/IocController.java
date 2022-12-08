package com.study.springboot202210changwoo.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IocController {

    // 'Ioc Container' 에 등록하지 않아도 사용하고 싶을 때는 required = false 하면됨(개발 단계에서 서버 실행만 해야 할 때[객체 구현이 안되어있을 때] 사용하는 방법)
    // 생략 가능(required = ture)
    @Autowired(required = true)
    @Qualifier("usi3") // usi2라는 별명을 가진 애를 써라.
    private UserService userService; // 'IoC controller' 는 개발자가 직접 생성을 안해도, 알아서 생성이 됨. @'Component' 를 달아놓으면, 생성을 자동으로 해줌

//    public IocController(UserServiceImpl2 userService) {
//        this.userService = userService;
//    } 원래라면 이걸 해줘야함.

    @ResponseBody
    @GetMapping("/ioc")
    public String iocTest() {
        userService.createUser();
        userService.getUser();
        userService.updateUser();
        userService.deleteUser();
        return null;
    }

}
