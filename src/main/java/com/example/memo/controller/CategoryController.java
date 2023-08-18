package com.example.memo.controller;

import com.example.memo.dto.CategoryDto;
import com.example.memo.entity.Category;
import com.example.memo.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {  // URL 에 {}로 감싸져있음. -> /categories/1
        return categoryService.getCategoryById(id);
    }

    // categories?keyword={검색어}&pag0&size=10&orderBy=name
    @GetMapping("")
    public Page<Category> getCategories(Pageable pageable, @RequestParam String keyword) {
        // pageable : 페이징 처리를 위한 파라미터(JPA) -> page=0&orderBy=name
        // RequestParam : URL에 추가적으로 붙음. get에는 body가 없기 때문에 body 대신 많이 씀. -> ?keyword={검색어}
        return categoryService.getCategories(pageable, keyword);
    }
}
