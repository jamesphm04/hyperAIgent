package com.db.hyperAIgent.domain.entities.openai;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {
    private String role;
    private String content;
}
