package com.springboot.board.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BasicEntity {
    
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdTime;

    @CreationTimestamp
    @Column(insertable = false)
    private LocalDateTime updatedTime;

}
