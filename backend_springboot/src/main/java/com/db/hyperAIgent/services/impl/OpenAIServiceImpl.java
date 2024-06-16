package com.db.hyperAIgent.services.impl;

import com.db.hyperAIgent.domain.entities.QAPairEntity;
import com.db.hyperAIgent.domain.entities.openai.MessageCompletionRequest;
import com.db.hyperAIgent.domain.entities.openai.MessageCompletionResponse;
import com.db.hyperAIgent.services.OpenAIService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OpenAIServiceImpl implements OpenAIService {
    final private RestTemplate restTemplate;

    public OpenAIServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void getResponse(List<QAPairEntity> history) {
        MessageCompletionRequest requestBody = new MessageCompletionRequest(history);

        MessageCompletionResponse response = restTemplate.postForObject(
                "https://api.openai.com/v1/chat/completions", requestBody,
                MessageCompletionResponse.class);
        // Check if response is null or empty
        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            throw new RuntimeException("Error: OpenAI response is null or empty.");
        }

        QAPairEntity qaPairEntity = history.get(0);
        qaPairEntity.setAnswer(response.getChoices().get(0).getMessage().getContent());
    }
}
