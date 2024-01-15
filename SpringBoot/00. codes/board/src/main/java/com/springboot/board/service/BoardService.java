package com.springboot.board.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.springboot.board.dto.BoardDTO;
import com.springboot.board.entity.BoardEntity;
import com.springboot.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

// DTO --> Entity (Entity class) || Entity --> DTO (DTO Class)
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        boardRepository.save(boardEntity);
    }

    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();

        for (BoardEntity boardEntity : boardEntityList) {
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }

        return boardDTOList;
    }
    
}
