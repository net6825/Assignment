package com.example.assignment.controller;

import com.example.assignment.domain.Member;
import com.example.assignment.domain.dto.BoardDTO;
import com.example.assignment.domain.dto.BoardFormDTO;
import com.example.assignment.domain.dto.RemoveBoardDTO;
import com.example.assignment.domain.dto.UpdateBoardDTO;
import com.example.assignment.repository.MemberRepository;
import com.example.assignment.service.serviceImpl.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.MemberRemoval;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardApiController {

    private final BoardServiceImpl boardService;
    private final MemberRepository memberRepository;


    @PostMapping("/list/post")
    public BoardDTO saveBoard(@RequestBody BoardFormDTO boardFormDTO, Principal principal) {
        BoardDTO save = boardService.save(boardFormDTO, principal);
        return save;
    }

    @PatchMapping("/list/patch")
    public BoardDTO updateBoard(@RequestBody UpdateBoardDTO updateBoardDTO) {
        System.out.println("AAA");
        BoardDTO boardDTO = boardService.updateBoard(updateBoardDTO);
        return boardDTO;
    }

    @DeleteMapping("/list/delete")
    public String removeBoard(@RequestBody Long id) {
        String remove = boardService.remove(id);
        return "redirect:board_list";
    }

//    @GetMapping("/dashboard/count")
//    public List<BoardDTO> searchCount() {
//        List<BoardDTO> boardDTOs = boardService.searchCount();
//        return boardDTOs;
//    }
//
//    @GetMapping("/dashboard/recently")
//    public List<BoardDTO> searchRecently() {
//        List<BoardDTO> boardDTOs = boardService.searchRecently();
//        return boardDTOs;
//    }
//
//    @GetMapping("/dashboard/title")
//    public List<BoardDTO> searchBoard(@RequestParam("title") String title) {
//        List<BoardDTO> boardDTOs = boardService.search(title);
//        return boardDTOs;
//    }

}
