package com.example.assignment.service.serviceImpl;

import com.example.assignment.domain.Board;
import com.example.assignment.domain.dto.BoardDTO;
import com.example.assignment.domain.dto.BoardFormDTO;
import com.example.assignment.domain.dto.RemoveBoardDTO;
import com.example.assignment.domain.dto.UpdateBoardDTO;
import com.example.assignment.repository.BoardRepository;
import com.example.assignment.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public List<BoardDTO> findAll() {
        List<Board> all = boardRepository.findAll(Sort.by(Sort.Direction.DESC,"createdAt"));
        List<BoardDTO> boardDTOs = new ArrayList<>();
        all.stream().map(board -> board.toBoardDTO()).forEach(boardDTOs::add);
        return boardDTOs;
    }

    @Override
    public BoardDTO findDetail(Long id) {
        Board board = boardRepository.findById(id).orElse(null);
        board.updateCount();
        BoardDTO boardDTO = board.toBoardDTO();
        return boardDTO;
    }

    @Override
    public BoardDTO updateBoard(UpdateBoardDTO boardDTO) {
        Long boardId = boardDTO.getId();
        Board board = boardRepository.findById(boardId).orElse(null);

        if(board.getPassword().equals(boardDTO.getPassword())){
            board.updateContent(boardDTO);
            BoardDTO toBoardDTO = board.toBoardDTO();
            return toBoardDTO;
        }else{
            return null;
        }
    }

    @Override
    public BoardDTO save(BoardFormDTO boardFormDTO) {
        Board board = Board.builder()
                .title(boardFormDTO.getTitle())
                .password(boardFormDTO.getPassword())
                .content(boardFormDTO.getContent())
                .createdAt(LocalDateTime.now())
                .count(0)
                .build();
        Board saveBoard = boardRepository.save(board);
        BoardDTO boardDTO = saveBoard.toBoardDTO();
        return boardDTO;
    }

    @Override
    public String remove(Long id) {
        Board board = boardRepository.findById(id).orElse(null);
        if(board!=null){
            boardRepository.deleteById(id);
            return "삭제됨";
        }else{
            return "삭제 안됨";
        }
    }

    @Override
    public List<BoardDTO> search(String title) {
        List<Board> boardList = boardRepository.findByTitleContains(title);
        List<BoardDTO> boardDTOs = new ArrayList<>();
        //boardList.stream().map(board -> board.toBoardDTO()).forEach(boardDTOs::add);
        return boardDTOs;
    }

    @Override
    public List<BoardDTO> searchCount() {
        List<Board> all = boardRepository.findAll(Sort.by(Sort.Direction.DESC,"count"));
        List<BoardDTO> boardDTOs = new ArrayList<>();
        all.stream().map(board -> board.toBoardDTO()).forEach(boardDTOs::add);
        return boardDTOs;
    }

    @Override
    public List<BoardDTO> searchRecently() {
        List<Board> all = boardRepository.findAll(Sort.by(Sort.Direction.DESC,"createdAt"));
        List<BoardDTO> boardDTOs = new ArrayList<>();
        all.stream().map(board -> board.toBoardDTO()).forEach(boardDTOs::add);
        return boardDTOs;
    }
}
