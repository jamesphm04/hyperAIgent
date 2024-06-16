package com.db.hyperAIgent.services.impl;

import com.db.hyperAIgent.domain.entities.ChatEntity;
import com.db.hyperAIgent.domain.entities.UserEntity;
import com.db.hyperAIgent.repositories.ChatRepository;
import com.db.hyperAIgent.services.ChatService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ChatServiceImpl implements ChatService {
    final private ChatRepository chatRepository;

    public ChatServiceImpl(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public ChatEntity create(ChatEntity chatEntity) {
        return chatRepository.save(chatEntity);
    }

    @Override
    public List<ChatEntity> findAll(UserEntity userEntity) {
        return chatRepository.findByUser(userEntity);
    }

    @Override
    public void delete(Long id) {
        Optional<ChatEntity> optionalChatEntity = chatRepository.findById(id);

        if (optionalChatEntity.isPresent()) {
            ChatEntity existingChatEntity = optionalChatEntity.get();

            existingChatEntity.setDeletedAt(LocalDateTime.now());
            chatRepository.save(existingChatEntity);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    @Override
    public Optional<ChatEntity> findOne(Long chatId) {
        Optional<ChatEntity> optionalExistingChatEntity = chatRepository.findById(chatId);
        if (optionalExistingChatEntity.isPresent() && optionalExistingChatEntity.get().getDeletedAt() == null) {
            return optionalExistingChatEntity;
        } else {
            throw new RuntimeException("Chat not found or deleted with id: " + chatId);
        }
    }
}
