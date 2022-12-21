package com.study.springboot202210changwoo.web.controller;

import com.study.springboot202210changwoo.web.dto.CMRespDto;
import com.study.springboot202210changwoo.web.dto.UserDto;
import com.study.springboot202210changwoo.web.exception.CustomTestException;
import com.sun.net.httpserver.Headers;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController // 데이터 응답: api
public class RestController1 {

    // 'ResponseBody' 와 'String' 이 만나면 'text/plain' 이고
    @GetMapping("/api/test/user-dto/str") // 이렇게만 해두면 handler 'mapping' 에 이 클래스와 이 메소드를 등록하겠다.
    public String getUserDtoStr() {
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        return userDto.toString(); // 클라이언트가 주소창에 요청주소에 해당하는 get 요청을 날리면 문자열을 리턴(응답)
    }

    // 'ResponseBody' 와 객체가 만나면 'application json'
    @GetMapping("/api/test/user-dto/obj")
    public UserDto getUserDtoObj() { // 메소드의 리턴타입이 'UserDto' 이기 때문에,
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        return userDto; // 리턴은 userDto 객체가 되어야 한다.
        // 객체를 응답해줄 때는 'json' 으로 자동으로 파싱되어서 응답됨 // 최상위 'object' 니깐 업캐스팅 되어있는데, 자동으로 'RestController' 에 의해서 다운캐스팅 됨.
    }

    @GetMapping("/api/test/user-dto/entity")
    public ResponseEntity<UserDto> getUserDtoEntity() { // 상태코드를 수동으로 달아줄 필요 없음 ResponseEntity 쓰면
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
//        return new ResponseEntity(userDto, null, 400);
        return new ResponseEntity<UserDto>(userDto, HttpStatus.INTERNAL_SERVER_ERROR);
        // 'ResponseEntity' 로 한번 감싸서 객체를 응답하겠다.
    }

    @GetMapping("/api/test/user-dto/entity2")
    public ResponseEntity<?> getUserDtoEntityTwo() { // 이 <?> 와일드카드는 최상위 Object 객체와 비슷함
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();

////        return new ResponseEntity<>("userDto", HttpStatus.INTERNAL_SERVER_ERROR);
//        return new ResponseEntity<>(1000, HttpStatus.INTERNAL_SERVER_ERROR);
//        return new ResponseEntity<>(userDto, HttpStatus.INTERNAL_SERVER_ERROR); -> userDto -> 'Body' 임
        //위의 3개보다 객체 생성할 때 더 직관적인 방법: 빌더 패턴

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userDto); // 위와 동일한데 직관적임
        // .ok()가 'badRequest()' 가 될수도 있음 // 지원안하는 것도 있는데 .status(HttpStatus.FORBIDDEN)이런식으로 해도 됨.
        // body() 안에는 응답할 데이터가 들어감.


    }

    // 응답헤더에 'key' 와 'value'  추가 하는 방법
    @GetMapping("/api/test/user-dto/entity3")
    public ResponseEntity<?> getUserDtoEntityThree() {
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.set("UserDto", userDto.toString());
//        return new ResponseEntity<>(headers, HttpStatus.OK);

        return ResponseEntity.ok()
                .headers(headers)
                .body(userDto);
    }

    @GetMapping("/api/test/user-dto/cm")
    public ResponseEntity<?> getUserDto() {
        UserDto userDto = UserDto.builder()
                .username("test")
                .password("1234")
                .build();

        return ResponseEntity.ok().body(new CMRespDto<>("test 유저 정보 응답", userDto)); // userDto => 'data: ' 임, 없으면 'null' 로 비워둬도 됨
        // 무조건 응답은 'CMRespDto' 안에 담아서 보내기
        // CMRespDto : 공통 응답 객체 => CM: 커밋 -> 커밋메세지를 같이 담겨있음. 이 메세지에 오류메세지나 데이터가 잘 들어갔는지 등의 메세지를 넣어서 프론트엔드 쪽에 알려줄 수 있음.

    }

    @PostMapping("/api/test/user")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {

        if(userDto.getUsername().isBlank()) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("username", "아이디를 입력하세요.");

            throw new CustomTestException("유효성 검사 실패", errorMap);
        }

        userDto.setUserId(200);

        return ResponseEntity.created(null)
                .body(new CMRespDto<>(userDto.getUserId() + "사용자 추가 성공!", userDto));
    }
}
