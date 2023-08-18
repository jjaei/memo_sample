package com.example.memo.memo.controller;

import com.example.memo.memo.dto.MemoDto;
import com.example.memo.memo.entity.Memo;
import com.example.memo.memo.service.MemoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/memos")
@AllArgsConstructor
public class MemoController {
    private final MemoService memoService;

    @PostMapping("")
    public Memo createMemo(@RequestBody MemoDto memoDto) {
        return memoService.createMemo(memoDto);
    }

    @GetMapping("/{id}")
    public Memo getMemoById(@PathVariable Long id) {
        return memoService.getMemoById(id);
    }

    @GetMapping("")
    public Page<Memo> getMemos(Pageable pageable, @RequestParam String keyword) {
        return memoService.getMemos(pageable, keyword);
    }

    @DeleteMapping("/{id}")
    public Memo deleteMemo(@PathVariable Long id) {
        return memoService.deleteMemo(id);
    }

    @PutMapping("/{id}")
    public Memo updateMemo(@PathVariable Long id, @RequestBody MemoDto memoDto) {
        return memoService.updateMemo(memoDto);
    }
}
