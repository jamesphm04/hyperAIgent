package com.db.hyperAIgent.repositories;

import com.db.hyperAIgent.domain.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
