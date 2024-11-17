package com.elliotesco.ports.user;

import com.elliotesco.entities.User;
import reactor.core.publisher.Mono;

public interface IUserRepositoryPort {
    Mono<User> save(User user);
    Mono<User> findById(String id);
}
