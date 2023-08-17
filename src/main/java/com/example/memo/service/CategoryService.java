package com.example.memo.service;

import com.example.memo.dto.CategoryDto;
import com.example.memo.entity.Category;
import com.example.memo.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor  // 모든 변수를 포함하는 생성자를 만들어줌.
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional  // 예외가 발생하면 데이터베이스를 롤백해주는 기능 제공
    public Category createCategory(CategoryDto categoryDto) {
        // Repository에서 데이터 가져오기
        Optional<Category> findOne = categoryRepository.findByName(categoryDto.getName());
        if (findOne.isPresent()) { // 데이터가 이미 존재하면 예외 발생시키고 종료
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "중복된 이름입니다.");
        }
        Category category = Category.builder()
                .name(categoryDto.getName())
                .build();
        category = categoryRepository.save(category); // 아니면 category 생성하기

        return category;
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(  // 데이터가 있다면 데이터를 가지고 오고, 없다면 예외 발생
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "카테고리가 존재하지 않습니다.")
        );
    }
}
