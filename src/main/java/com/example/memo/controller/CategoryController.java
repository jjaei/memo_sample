package com.example.memo.controller;

import com.example.memo.dto.CategoryDto;
import com.example.memo.entity.Category;
import com.example.memo.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // 모든 데이터의 요청과 응답의 body를 json 형태로 전송
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("")
    public Category createCategory(@RequestBody CategoryDto categoryDto) {
        // requestBody는 HTTP 요청의 body 부분을 가지고 오며 body의 내용을 UserDto에 담아서 처리해준다.
        return categoryService.createCategory(categoryDto);
    }
}
