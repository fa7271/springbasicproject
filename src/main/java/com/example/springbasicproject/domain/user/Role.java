package com.example.springbasicproject.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    // 스프링 시큐리티 권한 코드는 항상 ROLE_ 이 앞에 필요함

    GUEST("ROEL_GUEST", "손님"),
    USER("ROLE_USER","일반 사용자");

    private final String key;
    private final String title;



}
