package com.example.memo.category.dto;

import lombok.Data;

@Data // 모든 프로퍼티에 Getter, Setter, toString, hash 생성해주는 애노테이션
public class CategoryDto {
    String name;
}
