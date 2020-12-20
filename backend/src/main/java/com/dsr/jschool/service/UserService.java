package com.dsr.jschool.service;

import com.dsr.jschool.data.entity.User;
import com.dsr.jschool.data.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        var result = new ArrayList<User>();
        userRepository.findAll().forEach(result::add);
        return result;
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User createOrUpdateUser(User user) {
        return userRepository.save(user);
    }
}
