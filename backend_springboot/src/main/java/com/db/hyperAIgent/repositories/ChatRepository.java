package com.db.hyperAIgent.repositories;

import com.db.hyperAIgent.domain.entities.ChatEntity;
import com.db.hyperAIgent.domain.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChatRepository extends CrudRepository<ChatEntity, Long> {
    List<ChatEntity> findByUser(UserEntity userEntity);
}
