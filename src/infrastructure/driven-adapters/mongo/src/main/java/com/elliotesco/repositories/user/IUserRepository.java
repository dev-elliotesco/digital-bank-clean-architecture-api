package com.elliotesco.repositories.user;

import com.elliotesco.entities.user.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IUserRepository extends ReactiveCrudRepository<UserEntity, String> {
}
