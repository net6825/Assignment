package com.example.assignment.initDB;

import com.example.assignment.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Transactional
@RequiredArgsConstructor
public class InitBoardService {

    private final EntityManager em;

    String str = "2023-11-04 13:47:13.248";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

    public void init() {
        Board board0 = createBoard("제목가", "password0", "content1", dateTime, 0);
        Board board1 = createBoard("제목나", "password1", "content1", dateTime, 19);
        Board board2 = createBoard("제목다", "password2", "content2", dateTime, 18);
        Board board3 = createBoard("제목라", "password3", "content3", dateTime, 17);
        Board board4 = createBoard("제목마", "password4", "content4", LocalDateTime.now(), 16);
        Board board5 = createBoard("제목바", "password5", "content5", LocalDateTime.now(), 15);
        Board board6 = createBoard("제목사", "password6", "content6", LocalDateTime.now(), 14);
        Board board7 = createBoard("제목아", "password7", "content7", LocalDateTime.now(), 13);
        Board board8 = createBoard("제목자", "password8", "content8", LocalDateTime.now(), 19);
        Board board9 = createBoard("제목차", "password9", "content9", LocalDateTime.now(), 10);
        Board board10 = createBoard("제목카", "password10", "content10", LocalDateTime.now(), 11);
        Board board11 = createBoard("제목타", "password11", "content11", LocalDateTime.now(), 12);
        Board board12 = createBoard("제목파", "password12", "content12", LocalDateTime.now(), 8);
        Board board13 = createBoard("제목하", "password13", "content13", LocalDateTime.now(), 7);
        Board board14 = createBoard("제목가나", "password14", "content14", LocalDateTime.now(), 6);
        Board board15 = createBoard("제목다라", "password15", "content15", LocalDateTime.now(), 5);
        Board board16 = createBoard("제목마바", "password16", "content16", LocalDateTime.now(), 4);
        Board board17 = createBoard("제목사아", "password17", "content17", LocalDateTime.now(), 3);
        Board board18 = createBoard("제목자차", "password18", "content18", LocalDateTime.now(), 2);
        Board board19 = createBoard("제목카타", "password19", "content19", LocalDateTime.now(), 1);
        Board board20 = createBoard("제목파하", "password20", "content20", dateTime, 0);

    }

    private Board createBoard(String title, String password, String content, LocalDateTime createdAt, int count) {
        Board board = Board.builder()
                .title(title)
                .password(password)
                .content(content)
                .createdAt(createdAt)
                .count(count)
                .build();
        em.persist(board);

        return board;
    }

}
