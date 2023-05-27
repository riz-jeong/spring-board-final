package com.example.blog_board.service;

import com.example.blog_board.domain.Board;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardService {
    int boardCount();

    List<Board> boardList();

    Board findById(Long boardId);

    @Transactional
    Long add(Board board);

    @Transactional
    void update(Board board);

    void deleteById(Long boardId);
}
