package com.study.springboot202210changwoo.IocAndDi;

import org.springframework.stereotype.Component;


// 'Spring boot Application' 에서 'ComponantScan' 이 '@Component' 달린애들을 IcC 컨테이너을 new 해서 객체를 생성해서 쌓아둔다.(유일하게 딱하나만 UserServiceImpl2가 생성되어있음(싱글톤))
// Autowired 를 만나면 'IocContainer' 를 스캔하게 됨. 그럼  '@Autowired' 의 private UserService userService; 안에 DI를 함(의존성 주입) -> 프로그램을 실행하면 자동 생성과 자동 주입이 일어남.
@Component("usi2")
public class UserServiceImpl2 implements UserService {

    @Override
    public void createUser() {
        System.out.println("사용자 등록2");
    }

    @Override
    public void getUser() {
        System.out.println("사용자 조회2");
    }

    @Override
    public void updateUser() {
        System.out.println("사용자 수정2");
    }

    @Override
    public void deleteUser() {
        System.out.println("사용자 삭제2");
    }
}
