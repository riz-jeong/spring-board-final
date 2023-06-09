package com.example.blog_board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.blog_board.domain.Board;
import com.example.blog_board.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/hello")
    public String Hello(){
        return "/board/hello";
    }

    @GetMapping("/test")
    public String test(Model model){
        int boardCount = boardService.boardCount();
        List<Board> boardList = boardService.boardList();

        model.addAttribute("cnt", boardCount);
        model.addAttribute("test", boardList);

        return "/board/hello";
    }

    @GetMapping
    public String main(Model model){
        /* TODO board 리스트 조회 구현 */
        List<Board> boards = boardService.boardList();
        model.addAttribute("boards", boards);

        return "/board/boards";
    }

    @GetMapping("/{boardId}")
    public String board(@PathVariable long boardId, Model model){
        /* TODO board id로 board 조회 */
        Board board = boardService.findById(boardId);
        model.addAttribute("board", board);

        return "/board/board";
    }

    @PostMapping("/add")
    public String add(@RequestParam String title, @RequestParam String content,
                        @RequestParam String name, RedirectAttributes redirectAttributes){
        /* TODO board 객체 생성하여 board 추가 */
        Board newBoard = new Board(title, content, name);
        Long boardId = boardService.add(newBoard);

        redirectAttributes.addAttribute("boardId", boardId);
        redirectAttributes.addAttribute("status", true);

        return "redirect:/boards/{boardId}";
    }

    @GetMapping("/{boardId}/edit")
    public String editForm(@PathVariable Long boardId, Model model){
        /* TODO 수정 작업 전에 board id로 기존 board 조회 */
        Board findBoard = boardService.findById(boardId);
        model.addAttribute("board", findBoard);

        return "/board/editForm";
    }

    @PostMapping("/{boardId}/edit")
    public String editForm(@PathVariable Long boardId, @RequestParam String title,
                            @RequestParam String content, @RequestParam String name){
        /* TODO 수정 작업 board 속성 값을 받아 board 업데이트 */
        Board board = boardService.findById(boardId);
        board.setTitle(title);
        board.setContent(content);
        board.setName(name);

        boardService.update(board);

        return "redirect:/boards/{boardId}";
    }

    @GetMapping("/{boardId}/delete")
    public String deleteBoard(@PathVariable Long boardId){
        /* TODO board id에 해당하는 board 삭제 */
        boardService.deleteById(boardId);
        return "redirect:/boards";
    }

    @GetMapping("/add")
    public String add(){
        return "/board/addForm";
    }


}
