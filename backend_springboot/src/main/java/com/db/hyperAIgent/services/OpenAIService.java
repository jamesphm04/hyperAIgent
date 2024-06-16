package com.db.hyperAIgent.services;

import com.db.hyperAIgent.domain.entities.QAPairEntity;

import java.util.List;

public interface OpenAIService {

    void getResponse(List<QAPairEntity> history);
}
