package com.db.hyperAIgent.domain.entities.openai;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageCompletionResponse {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Choice {
        private int index;
        private Message message;
    }

    private List<Choice> choices;
}
