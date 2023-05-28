package com.example.blog_board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.blog_board.domain.Board;

@Repository
@Mapper
public interface BoardMapper{

    int boardCount();

    List<Board> findAll();

    Board findById(Long boardId);

    void save(Board board);

    void update(Board board);

    void delete(Long boardId);

    void increaseReadCnt(Long boardId);
}

