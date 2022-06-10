package com.example.assignment.repository;

import com.example.assignment.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {
    List<Board> findByTitleContains(@Param("title")String title);
}
