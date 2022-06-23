package com.example.assignment.controller;

import com.example.assignment.domain.dto.BoardDTO;
import com.example.assignment.service.serviceImpl.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/list/{id}")
    public String detail(Model model, @PathVariable("id")Long id){
        BoardDTO detail = boardService.findDetail(id);
        model.addAttribute("detail", detail);
        return "board_detail";
    }

    @GetMapping("/list/create")
    public String create(){
        return "board_create";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<BoardDTO> all = boardService.findAll();
        model.addAttribute("list",all);
        return "board_list";
    }

    @GetMapping("/list/update/{id}")
    public String update(Model model, @PathVariable("id") Long id) {
        BoardDTO detail = boardService.findDetail(id);
        model.addAttribute("detail", detail);
        return "board_update";
    }
}
