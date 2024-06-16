package com.db.hyperAIgent.services.impl;

import com.db.hyperAIgent.domain.entities.UserEntity;
import com.db.hyperAIgent.repositories.UserRepository;
import com.db.hyperAIgent.services.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    final private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity createUpdate(UserEntity user) {
        //TODO duplicate email
        return userRepository.save(user);
    }

    @Override
    public boolean isExist(Long id) {
        Optional<UserEntity> optionalExistingUserEntity = userRepository.findById(id);
        if (optionalExistingUserEntity.isPresent() && optionalExistingUserEntity.get().getDeletedAt() == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<UserEntity> findOne(Long id) {
        Optional<UserEntity> optionalExistingUserEntity = userRepository.findById(id);
        if (optionalExistingUserEntity.isPresent() && optionalExistingUserEntity.get().getDeletedAt() == null) {
            return optionalExistingUserEntity;
        } else {
            throw new RuntimeException("User not found or deleted with id: " + id);
        }
    }

    @Override
    public UserEntity partialUpdate(Long id, UserEntity userEntity) {
        userEntity.setId(id);

        Optional<UserEntity> optionalExistingUserEntity = userRepository.findById(id);
        if (optionalExistingUserEntity.isPresent() && optionalExistingUserEntity.get().getDeletedAt() == null) {
            UserEntity existingUserEntity = optionalExistingUserEntity.get();

            if (userEntity.getName() != null) {
                existingUserEntity.setName(userEntity.getName());
            }

            if (userEntity.getEmail() != null) {
                existingUserEntity.setEmail(userEntity.getEmail());
            }

            if (userEntity.getPassword() != null) {
                existingUserEntity.setPassword(userEntity.getPassword());
            }

            return userRepository.save(existingUserEntity);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);

        if (optionalUserEntity.isPresent()) {
            UserEntity existingUserEntity = optionalUserEntity.get();

            existingUserEntity.setDeletedAt(LocalDateTime.now());
            userRepository.save(existingUserEntity);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
}
