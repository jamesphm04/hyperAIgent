package com.db.hyperAIgent.services.impl;

import com.db.hyperAIgent.domain.entities.ChatEntity;
import com.db.hyperAIgent.domain.entities.QAPairEntity;
import com.db.hyperAIgent.repositories.QAPairRepository;
import com.db.hyperAIgent.services.QAPairService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QAPairServiceImpl implements QAPairService {
    final private QAPairRepository qaPairRepository;

    public QAPairServiceImpl(QAPairRepository qaPairRepository) {
        this.qaPairRepository = qaPairRepository;
    }

    @Override
    public QAPairEntity create(QAPairEntity newQAPairEntity) {
        return qaPairRepository.save(newQAPairEntity);
    }

    @Override
    public List<QAPairEntity> findAll(ChatEntity chatEntity) {
        return qaPairRepository.findByChat(chatEntity);
    }
}
