package com.db.hyperAIgent.repositories;

import com.db.hyperAIgent.domain.entities.ChatEntity;
import com.db.hyperAIgent.domain.entities.QAPairEntity;
import com.db.hyperAIgent.domain.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QAPairRepository extends CrudRepository<QAPairEntity, Long> {
    List<QAPairEntity> findByChat(ChatEntity chatEntity);
}
