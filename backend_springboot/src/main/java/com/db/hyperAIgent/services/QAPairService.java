package com.db.hyperAIgent.services;


import com.db.hyperAIgent.domain.entities.ChatEntity;
import com.db.hyperAIgent.domain.entities.QAPairEntity;

import java.util.List;

public interface QAPairService {
    QAPairEntity create(QAPairEntity newQAPairEntity);

    List<QAPairEntity> findAll(ChatEntity chatEntity);
}
