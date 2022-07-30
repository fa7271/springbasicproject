package com.example.springbasicproject.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface
UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email); // optional 이란 null 일 수도 있는 객체를 감싸는 wrapper 클래스
}
