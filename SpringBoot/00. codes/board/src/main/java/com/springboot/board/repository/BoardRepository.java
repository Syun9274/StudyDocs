package com.springboot.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.board.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

}
