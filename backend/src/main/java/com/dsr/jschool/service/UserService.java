package com.dsr.jschool.service;

import com.dsr.jschool.data.dto.security.RegisterUserDto;
import com.dsr.jschool.data.entity.User;
import com.dsr.jschool.data.repository.RoleRepository;
import com.dsr.jschool.data.repository.UserRepository;
import com.dsr.jschool.exeption.NotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public List<User> getAllUsers() {
        var result = new ArrayList<User>();
        userRepository.findAll().forEach(result::add);
        return result;
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void registerUser(RegisterUserDto dto) {
        var userRole = roleRepository.findByName("ROLE_USER");
        var user = new User();
        user.setName(dto.getLogin());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRoles(Collections.singletonList(userRole));
        userRepository.save(user);
    }

    public User findByLoginAndPassword(String login, String password) {
        var user = userRepository.findByName(login);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    public User findByLogin(String login) {
        if(userRepository.findByName(login) == null)
            throw new NotFoundException();
        return userRepository.findByName(login);
    }
}
