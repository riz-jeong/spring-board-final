package com.example.blog_board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.blog_board.domain.Board;
import com.example.blog_board.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
@Transactional //(readOnly = true)
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    @Override
    public int boardCount(){
        return boardMapper.boardCount();
    }

    @Override
    public List<Board> boardList(){
        return boardMapper.findAll();
    }

    @Override
    public Board findById(Long boardId){
        boardMapper.increaseReadCnt(boardId);
        return boardMapper.findById(boardId);
    }

    @Override
    @Transactional
    public Long add(Board board) {
        boardMapper.save(board);
        return board.getBoardId();
    }

    @Override
    @Transactional
    public void update(Board board){
        boardMapper.update(board);
    }

    @Override
    public void deleteById(Long boardId) {
        boardMapper.delete(boardId);
    }
}