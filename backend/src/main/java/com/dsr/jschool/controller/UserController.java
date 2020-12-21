package com.dsr.jschool.controller;

import com.dsr.jschool.data.dto.UserDto;
import com.dsr.jschool.data.mapper.UserMapper;
import com.dsr.jschool.service.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    private final UserMapper mapper = Mappers.getMapper(UserMapper.class);

    public UserController(UserService userService,
                          UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping(path = "")
    public List<UserDto> getUsers() {
        return mapper.userToUserDto(userService.getAllUsers());
    }

    @GetMapping(path = "/{id}")
    public UserDto getUser(Long id) {
        return userMapper.userToUserDto(userService.getUser(id));
    }
}
