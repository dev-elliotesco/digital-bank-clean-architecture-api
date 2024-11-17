package com.elliotesco.mappers.user;

import com.elliotesco.dtos.user.UserRequestDTO;
import com.elliotesco.dtos.user.UserResponseDTO;
import com.elliotesco.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toUser(UserRequestDTO userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setAddress(userRequest.getAddress());
        return user;
    }

    public UserResponseDTO toUserResponseDTO(User user) {
        UserResponseDTO response = new UserResponseDTO();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setAddress(user.getAddress());
        return response;
    }
}
