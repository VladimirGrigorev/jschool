package com.dsr.jschool.data.mapper;

import com.dsr.jschool.data.dto.UserDto;
import com.dsr.jschool.data.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper{

    UserDto userToUserDto(User user);
    List<UserDto> userToUserDto(List<User> users);
}
