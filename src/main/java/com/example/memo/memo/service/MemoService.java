package com.example.memo.memo.service;

import com.example.memo.category.entity.Category;
import com.example.memo.category.repository.CategoryRepository;
import com.example.memo.memo.dto.MemoDto;
import com.example.memo.memo.entity.Memo;
import com.example.memo.memo.repository.MemoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MemoService {
    private MemoRepository memoRepository;
    private CategoryRepository categoryRepository;

    public Memo createMemo(MemoDto memoDto) {
        Optional<Memo> findOne = memoRepository.findByName(memoDto.getName());
        if (findOne.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "중복된 이름입니다.");
        }

        Category category = categoryRepository.getCategoryById(memoDto.getCategory_id());

        Memo memo = Memo.builder()
                .id(memoDto.getId())
                .name(memoDto.getName())
                .content(memoDto.getContent())
                .category(category)
                .build();

        return memoRepository.save(memo);
    }

    public Memo getMemoById(Long id) {
        return memoRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "메모가 존재하지 않습니다.")
        );
    }

    public Page<Memo> getMemos(Pageable pageable, String keyword) {
        if (keyword == null) {
            return memoRepository.findAll(pageable);
        } else {
            return memoRepository.findByNameContains(pageable, keyword);
        }
    }

    public Memo deleteMemo(Long id) {
        Memo memo =  memoRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "삭제할 메모가 없습니다.")
        );
        memoRepository.deleteById(id);
        return memo;
    }

    public Memo updateMemo(MemoDto memoDto) {
        Optional<Memo> existMemo = memoRepository.findById(memoDto.getId());
        if (existMemo.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정할 메모가 존재하지 않습니다.");
        }

        Memo memo = Memo.builder()
                .id(memoDto.getId())
                .name(memoDto.getName())
                .content(memoDto.getContent())
                .category(existMemo.get().getCategory())
                .build();

        return memoRepository.save(memo);
    }
}
