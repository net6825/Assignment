package com.example.assignment.service;

import com.example.assignment.domain.Board;
import com.example.assignment.domain.dto.BoardDTO;
import com.example.assignment.domain.dto.BoardFormDTO;
import com.example.assignment.domain.dto.RemoveBoardDTO;
import com.example.assignment.domain.dto.UpdateBoardDTO;

import java.util.List;

public interface BoardService {

    List<BoardDTO> findAll();
    BoardDTO findDetail(Long id);
    BoardDTO updateBoard(UpdateBoardDTO boardDTO);
    BoardDTO save(BoardFormDTO boardFormDTO);
    String remove(RemoveBoardDTO removeBoardDTO);
    List<BoardDTO> search(String title);
    List<BoardDTO> searchCount();

    List<BoardDTO> searchRecently();

}
