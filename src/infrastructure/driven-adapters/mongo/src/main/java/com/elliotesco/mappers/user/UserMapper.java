package com.elliotesco.mappers.user;


import com.elliotesco.entities.User;
import com.elliotesco.entities.user.UserEntity;
import com.elliotesco.mappers.account.AccountMapper;

import java.util.stream.Collectors;

public class UserMapper {
    public static UserEntity toEntity(User user) {
        if (user == null) {
            return null;
        }
        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getAddress(),
                user.getAccounts() != null ? user.getAccounts().stream()
                        .map(AccountMapper::toEntity)
                        .collect(Collectors.toList()) : null
        );
    }

    public static User toModel(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        return new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getAddress(),
                userEntity.getAccounts() != null ? userEntity.getAccounts().stream()
                        .map(AccountMapper::toModel)
                        .collect(Collectors.toList()) : null
        );
    }
}