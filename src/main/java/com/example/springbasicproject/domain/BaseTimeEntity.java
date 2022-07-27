package com.example.springbasicproject.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

// 생성시간 / 수정시간 자동화 하기

@Getter
@MappedSuperclass // BaseTimeEntity 을 상속할 경우 필드들을 칼럼으로 인식함
@EntityListeners(AuditingEntityListener.class) // BaseTimeEntity 에 auditing 기능을 포함시 , 해당 데이터를 보고 있다가 생성 또는 수정이 발생하면 자동으로 값을 넣어
public abstract class BaseTimeEntity { // entity의 상위 클래스가 되어 entity의 date를 자동으로 관리하는 역할

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}


