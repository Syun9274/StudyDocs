package com.springboot.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.board.entity.BoardEntity;
import com.springboot.board.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    // select * from comment_table where board_id=? order by id desc;
    List<CommentEntity> findAllByBoardEntityOrderByIdDesc(BoardEntity boardEntity);
}
