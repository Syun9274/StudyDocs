package com.springboot.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.board.entity.BoardFileEntity;

public interface BoardFileRepository extends JpaRepository<BoardFileEntity, Long> {
    
}
