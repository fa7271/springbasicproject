package com.example.springbasicproject.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest // 자동으로 h2 데이터베이스를 실행해준다.
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // 테스트 끝나면 수행되는 메소드
    public void cleandup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() //insert / update 쿼리 수행   id가 있으면 update, 없으면 insert
                .title(title)
                .content(content)
                .author("song@naver.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll(); // 모든 값 조회해서 리스트로 저장

        //then

        Posts posts = postsList.get(0);
        Assertions.assertThat(posts.getTitle()).isEqualTo(title);
        Assertions.assertThat(posts.getContent()).isEqualTo(content);
    }
}