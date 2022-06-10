package com.example.assignment.controller;

import com.example.assignment.domain.dto.BoardDTO;
import com.example.assignment.domain.dto.BoardFormDTO;
import com.example.assignment.domain.dto.RemoveBoardDTO;
import com.example.assignment.domain.dto.UpdateBoardDTO;
import com.example.assignment.service.serviceImpl.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardApiController {

    private final BoardServiceImpl boardService;

    @GetMapping("/dashboard")
    public List<BoardDTO> index() {
        List<BoardDTO> boardList = boardService.findAll();
        return boardList;
    }

    @GetMapping("/dashboard/{id}")
    public BoardDTO detailBoard(@PathVariable("id") Long id) {
        BoardDTO detail = boardService.findDetail(id);
        return detail;
    }

    @PostMapping("/dashboard")
    public BoardDTO saveBoard(@RequestBody BoardFormDTO boardFormDTO) {
        BoardDTO save = boardService.save(boardFormDTO);
        return save;
    }

    @PatchMapping("/dashboard")
    public BoardDTO updateBoard(@RequestBody UpdateBoardDTO updateBoardDTO) {
        BoardDTO boardDTO = boardService.updateBoard(updateBoardDTO);
        return boardDTO;
    }

    @DeleteMapping("/dashboard")
    public String removeBoard(Long id) {
        String remove = boardService.remove(id);
        return remove;
    }

    @GetMapping("/dashboard/count")
    public List<BoardDTO> searchCount() {
        List<BoardDTO> boardDTOs = boardService.searchCount();
        return boardDTOs;
    }

    @GetMapping("/dashboard/recently")
    public List<BoardDTO> searchRecently() {
        List<BoardDTO> boardDTOs = boardService.searchRecently();
        return boardDTOs;
    }

    @GetMapping("/dashboard/title")
    public List<BoardDTO> searchBoard(@RequestParam("title") String title) {
        List<BoardDTO> boardDTOs = boardService.search(title);
        return boardDTOs;
    }

}
