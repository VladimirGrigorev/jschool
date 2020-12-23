package com.dsr.jschool.controller;

import com.dsr.jschool.data.dto.UserWithListOrderDto;
import com.dsr.jschool.data.mapper.UserMapper;
import com.dsr.jschool.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/me")
public class CurrentUserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public CurrentUserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping(path = "")
    public UserWithListOrderDto getProfile(Authentication authentication) {
        String currentPrincipalName = authentication.getName();
        var user = userService.findByLogin(currentPrincipalName);
        return userMapper.userToUserWithListOrderDto(user);
    }
}
