package com.db.hyperAIgent.domain.dtos.openai;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatResponse {
    private Long id;
    private String topic;
    private Long userId;

    private List<SingleQAPair> conversation;
}
