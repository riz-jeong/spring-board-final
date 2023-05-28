package com.example.blog_board.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private Long boardId;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private Integer readCnt;
    private String name;

    private Long memberId;


    public Board(String title, String content, String name) {
        this.title = title;
        this.content = content;
        this.name = name;
    }

}

