package com.study.springboot202210changwoo.IocAndDi;


public class Main { // 스태틱메모리에 스태틱이 저장되어있음.(어디서든 꺼내서 쓸 수 있는 영역) -> 스프링에서는 스태틱 영역이 IcC 영역으로 바뀜

    private final UserService userService;

    public Main(UserService userService) {
        this.userService = userService;
    }

    public void run() {
        userService.createUser();
        userService.getUser();
        userService.updateUser();
        userService.deleteUser();
    }

    public static void main(String[] args) {
        UserService userService = UserServiceImpl.getInstance();
        // 'userService' 부품을 'Main' 을 생성할 때 매개변수 자리에() -> [의존성을]주입을 하는 방식을 DI(객체지향프로그램에 있음)라고 함.
        Main main = new Main(userService);
        main.run();
    }
}
