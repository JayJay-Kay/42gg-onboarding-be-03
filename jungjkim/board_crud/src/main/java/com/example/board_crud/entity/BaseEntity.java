package com.example.board_crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {
    @CreationTimestamp //작성시간
    @Column(updatable = false)
    private LocalDateTime createdTime;

    @UpdateTimestamp //업데이트시 시간
    @Column(insertable = false)
    private LocalDateTime updatedTime;
}
