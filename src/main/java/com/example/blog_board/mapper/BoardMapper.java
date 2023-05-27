package com.example.blog_board.mapper;

import com.example.blog_board.domain.Board;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
@Mapper
public interface BoardMapper{

    int boardCount();

    List<Board> findAll();

    Board findById(Long boardId);

    void save(Board board);

    void update(Board board);

    void delete(Long boardId);
}

