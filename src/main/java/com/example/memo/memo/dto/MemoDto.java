package com.example.memo.memo.dto;

import lombok.Data;

@Data
public class MemoDto {
    String name;
    String content;
    Long category_id;
}
