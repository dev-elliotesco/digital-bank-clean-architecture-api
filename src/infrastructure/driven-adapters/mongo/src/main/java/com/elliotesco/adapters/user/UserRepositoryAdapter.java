package com.elliotesco.adapters.user;

import com.elliotesco.entities.User;
import com.elliotesco.mappers.user.UserMapper;
import com.elliotesco.ports.user.IUserRepositoryPort;
import com.elliotesco.repositories.user.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements IUserRepositoryPort {

    private final IUserRepository userRepository;

    @Override
    public Mono<User> save(User user) {
        return userRepository.save(UserMapper.toEntity(user))
                .map(UserMapper::toModel);
    }

    @Override
    public Mono<User> findById(String id) {
        return userRepository.findById(id)
                .map(UserMapper::toModel);
    }
}
