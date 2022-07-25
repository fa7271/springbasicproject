package com.example.springbasicproject.service.posts;

import com.example.springbasicproject.domain.posts.Posts;
import com.example.springbasicproject.domain.posts.PostsRepository;
import com.example.springbasicproject.web.dto.PostsResponseDto;
import com.example.springbasicproject.web.dto.PostsSaveRequestDto;
import com.example.springbasicproject.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional // 등록
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
    @Transactional // 수정
    public Long update(Long id, PostsUpdateRequestDto postsUpdateRequestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        posts.update(postsUpdateRequestDto.getTitle(), postsUpdateRequestDto.getContent());
        return id;
    }

    @Transactional // 조회
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글 없습니다. id = " + id));
        return new PostsResponseDto(entity);
    }
}
