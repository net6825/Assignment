package com.example.assignment.controller;

import com.example.assignment.domain.dto.BoardDTO;
import com.example.assignment.service.serviceImpl.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardWebController {

    private final BoardServiceImpl boardService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/denied")
    public String denied(){
        return "denied";
    }

    @GetMapping("/list/detail")
    public String detail(Model model){
        return "board_detail";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<BoardDTO> all = boardService.findAll();
        model.addAttribute("list",all);
        return "board_list";
    }

    @GetMapping("/list_update")
    public String update(Model model){
        return "board_update";
    }
}
