package com.example.springbasicproject.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // entity 클래스는 절대 setter 메소드 없다. 이유: setter 가 있으면 해당 클래스의 인스턴스 값들이 언제 어디서 변해야 하는지 코드상 명확히 구분 못함.
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 생성 시점에 값을 채워 주는 역할 == 생성자가 해줄 수 도 있음
    private Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
