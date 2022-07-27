package com.example.springbasicproject.domain.posts;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    // JpaRepository<Entity클래스, PK타입> 을 상속하면 기본적인 CRUD 메소드가 자동으로 생성된다.

    @Query("SELECT a FROM Posts a ORDER BY a.id DESC ")
    List<Posts> findAllDesc();
}
