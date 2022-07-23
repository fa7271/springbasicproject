package com.example.springbasicproject.web;


import com.example.springbasicproject.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount){  // 외부에서 nam(@RequestParam("name")) 이란 이름으로 넘긴 값 name(String name) 으로 저장
        return new HelloResponseDto(name, amount);
    }
}

// RestController 란 컨트롤러를 json을 반환하는 컨트롤러를 만들어 줌
// @ResponsBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해주는 것

// GetMapping Get의 요청을 받을 수 있는 api 만듦


