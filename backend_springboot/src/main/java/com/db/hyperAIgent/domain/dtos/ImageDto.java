package com.db.hyperAIgent.domain.dtos;

import jakarta.persistence.Column;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public class ImageDto {
    private Long id;
    private byte[] image;
    private String role;
    private QAPairDto qa_pair;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;
}
