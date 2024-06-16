package com.db.hyperAIgent.domain.entities.openai;

import com.db.hyperAIgent.domain.entities.QAPairEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageCompletionRequest {
    private String model = "gpt-3.5-turbo";
    private List<Message> messages = new ArrayList<>();;

    public MessageCompletionRequest(List<QAPairEntity> history) {

        String question = history.get(0).getQuestion();
        this.messages.add(new Message("user", question));//TODO number of qa pair in history can be filter by limit the query
    }

}
