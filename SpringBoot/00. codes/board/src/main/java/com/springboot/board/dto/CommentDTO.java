package com.springboot.board.dto;

import java.time.LocalDateTime;

import com.springboot.board.entity.CommentEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentDTO {
    private Long id;
    private String commentWriter;
    private String commentContents;
    private Long boardId;
    private LocalDateTime commentCreatedTime;

    public static CommentDTO toCommentDTO(CommentEntity commentEntity, Long boardId) {
        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setId(commentEntity.getId());
        commentDTO.setCommentWriter(commentEntity.getCommentWriter());
        commentDTO.setCommentContents(commentDTO.getCommentContents());
        commentDTO.setCommentCreatedTime(commentDTO.getCommentCreatedTime());
        commentDTO.setBoardId(boardId);

        return commentDTO;
    }
}
