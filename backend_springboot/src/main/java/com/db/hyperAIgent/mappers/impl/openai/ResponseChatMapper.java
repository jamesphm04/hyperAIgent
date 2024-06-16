package com.db.hyperAIgent.mappers.impl.openai;

import com.db.hyperAIgent.domain.dtos.openai.ChatResponse;
import com.db.hyperAIgent.domain.dtos.openai.SingleQAPair;
import com.db.hyperAIgent.domain.entities.ChatEntity;
import com.db.hyperAIgent.domain.entities.QAPairEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResponseChatMapper {
    public ChatResponse mapToResponse(ChatEntity chatEntity, List<QAPairEntity> history) {
        ChatResponse chatResponse = new ChatResponse();
        chatResponse.setId(chatEntity.getId());
        chatResponse.setTopic(chatEntity.getTopic());
        chatResponse.setUserId(chatEntity.getUser().getId());

        //map from pair
        List<SingleQAPair> conversation = new ArrayList<>();
        for (QAPairEntity qaPairEntity : history) {
            SingleQAPair singleQAPair = new SingleQAPair();

            singleQAPair.setQuestion(qaPairEntity.getQuestion());
            singleQAPair.setAnswer(qaPairEntity.getAnswer());

            conversation.add(singleQAPair);
        }

        chatResponse.setConversation(conversation);
        return chatResponse;
    }
}
