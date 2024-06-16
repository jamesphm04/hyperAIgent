package com.db.hyperAIgent.services;

import com.db.hyperAIgent.domain.entities.UserEntity;

import java.util.Optional;

public interface UserService {
    UserEntity createUpdate(UserEntity user);
    UserEntity partialUpdate(Long id, UserEntity authorEntity);
    Optional<UserEntity> findOne(Long id);
    boolean isExist(Long id);
    void delete(Long id);
}
