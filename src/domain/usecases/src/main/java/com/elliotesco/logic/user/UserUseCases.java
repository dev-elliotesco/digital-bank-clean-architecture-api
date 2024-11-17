package com.elliotesco.logic.user;

import com.elliotesco.dtos.user.UserRequestDTO;
import com.elliotesco.dtos.user.UserResponseDTO;
import com.elliotesco.entities.User;
import com.elliotesco.logic.account.AccountUseCases;
import com.elliotesco.mappers.user.UserMapper;
import com.elliotesco.ports.user.IUserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserUseCases {

    private final IUserRepositoryPort userRepositoryPort;
    private final UserMapper userMapper;
    private final AccountUseCases accountUseCases;

    public Mono<UserResponseDTO> registerUser(UserRequestDTO userRequest) {
        User user = userMapper.toUser(userRequest);
        return userRepositoryPort.save(user)
                .map(userMapper::toUserResponseDTO);
    }

    public Mono<Double> getTotalBalanceForUser(String userId) {
        return userRepositoryPort.findById(userId)
                .flatMap(user -> {
                    return Flux.fromIterable(user.getAccounts())
                            .flatMap(account -> accountUseCases.getBalance(account.getNumber()))
                            .reduce(0.0, Double::sum);
                });
    }
}
