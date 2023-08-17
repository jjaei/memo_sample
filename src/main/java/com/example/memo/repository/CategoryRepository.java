package com.example.memo.repository;

import com.example.memo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // 데이터를 접근하는 객체를 만들 때 생성
public interface CategoryRepository extends JpaRepository<Category, Long> { // <다루는 데이터 타입, id 타입>
    Optional<Category> findByName(String name);
}
