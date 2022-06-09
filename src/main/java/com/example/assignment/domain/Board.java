package com.example.assignment.domain;

import com.example.assignment.domain.dto.BoardDTO;
import com.example.assignment.domain.dto.UpdateBoardDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private int count;

    public void updateCount(){
        this.count++;
    }

    public void updateContent(UpdateBoardDTO boardDTO){
        this.content = boardDTO.getContent();
        this.title = boardDTO.getTitle();
    }

    public BoardDTO toBoardDTO(){

        BoardDTO board = BoardDTO.builder()
                .id(this.id)
                .password(this.password)
                .title(this.title)
                .content(this.content)
                .createdAt(this.createdAt)
                .count(this.count)
                .build();

        return board;
    }

}
