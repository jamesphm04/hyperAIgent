package com.db.hyperAIgent.services;

import com.db.hyperAIgent.domain.entities.ChatEntity;
import com.db.hyperAIgent.domain.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface ChatService {
    ChatEntity create(ChatEntity chatEntity);

    List<ChatEntity> findAll(UserEntity user);

    void delete(Long id);

    Optional<ChatEntity> findOne(Long chatId);
}
