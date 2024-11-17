package com.elliotesco.controllers.user;

import com.elliotesco.dtos.user.UserRequestDTO;
import com.elliotesco.dtos.user.UserResponseDTO;
import com.elliotesco.logic.user.UserUseCases;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController implements UserControllerDOC {

    private final UserUseCases userUseCases;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserResponseDTO> registerUser(@Valid @RequestBody UserRequestDTO userRequest) {
        return userUseCases.registerUser(userRequest);
    }

    @GetMapping("/total-balance/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Double> getTotalBalanceForUser(@PathVariable String userId) {
        return userUseCases.getTotalBalanceForUser(userId);
    }
}
