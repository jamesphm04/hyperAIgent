package com.db.hyperAIgent.domain.dtos.openai;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SingleQAPair {
    private String question;
    private String answer;
}
