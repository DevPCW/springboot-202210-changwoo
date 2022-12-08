package com.study.springboot202210changwoo.IocAndDi;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 사용목적이 다름 다른 컴포넌트들과 ㅎㅎ(객체를 설정한다는 의미로 'config' 임)
// 다른 컴포넌트들과 차이점은 걔네들도 'Bean' 등록을 할 수 있는데, 'Configuration' 은 이 'Bean' 등록이 두 개 이상 가능하다
public class TestConfig { // 수동적으로 'Bean' 객체를 등록 하는 거
    // 그렇다면 얘네들은 언제 쓰는가? ㅇㅇ
    // 라이브러리를 들고 왔을 때 라이브러리 안에서는 어노테이션 컴포넌트를 달아 줄 수가 없는데, 그런 경우 처럼 소스 코드 수정이 안될 때 수동으로 여러개의 객체 생성이 가능하다.

    @Bean
    public Test1 t1() { // 얘네들이 'Bean' 에 등록되어있다.
        return new Test1();
    }

    @Bean
    public Test2 t2() {
        return new Test2();
    }

}
