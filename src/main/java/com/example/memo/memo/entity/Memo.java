package com.example.memo.memo.entity;

import com.example.memo.category.entity.Category;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.EAGER)  // 외래키 설정,
    // EAGER : 첫 로딩 시 데이터를 같이 가지고 옴. Memo를 가지고 올 때 마다 Category의 데이터가 필요할 때 설정
    // LAZY : 나중에 getCategory를 사용하면 가지고 옴. 데이터가 항상 필요하지 않을 때 사용.
    @JoinColumn(name = "category_id")
    Category category;

    @Column(length = 100)
    String name;

    @Column(columnDefinition = "TEXT")
    // 타입 지정할 때 사용, TEXT는 사이즈 제한이 없는 텍스트를 저장 할 때 사용
    String content;

    @Builder
    public Memo(Category category, String name, String content) {
        this.category = category;
        this.name = name;
        this.content = content;
    }
}
