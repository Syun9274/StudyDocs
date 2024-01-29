package com.springboot.board2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.board2.entity.Board;
import com.springboot.board2.service.BoardService;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;
    
    @GetMapping("/board/write") // localhost:{port}/board/write
    public String boardWriteForm() {

        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board) {

        boardService.write(board);

        return " ";
    }
}
