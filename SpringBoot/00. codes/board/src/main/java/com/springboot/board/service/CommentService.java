package com.springboot.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.board.dto.CommentDTO;
import com.springboot.board.entity.BoardEntity;
import com.springboot.board.entity.CommentEntity;
import com.springboot.board.repository.BoardRepository;
import com.springboot.board.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    public Long save(CommentDTO commentDTO) {
        /* 부모Entity(BoardEntity) 조회 */
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(commentDTO.getBoardId());

        if(optionalBoardEntity.isPresent()) {
            BoardEntity boardEntity = optionalBoardEntity.get();
            CommentEntity commentEntity = CommentEntity.toSaveEntity(commentDTO, boardEntity);
            return commentRepository.save(commentEntity).getId();
        } else {
            return null;
        }
        
    }

    public List<CommentDTO> findAll(Long boardId) {
        BoardEntity boardEntity = boardRepository.findById(boardId).get();
        List<CommentEntity> commentEntityList = commentRepository.findAllByBoardEntityOrderByIdDesc(boardEntity);

        List<CommentDTO> commentDTOList = new ArrayList<>();
        for (CommentEntity commentEntity : commentEntityList) {
            CommentDTO commentDTO = CommentDTO.toCommentDTO(commentEntity, boardId);
            commentDTOList.add(commentDTO);
        }

        return commentDTOList;
    }
}
