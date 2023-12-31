package com.example.memo.category.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity // JPA에서 테이블 생성하고 테이블 데이터를 가지고 옴.
@Getter
@ToString
@NoArgsConstructor
public class Category {
    @Id  // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 값을 자동으로 생성해주는 설정
    Long id;

    @Column(length = 100, unique = true) // DB Column
    String name;

    @Builder
    public Category(String name) {
        this.name = name;
    }
}
