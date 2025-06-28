package com.cts.demo.service;

import com.cts.demo.User;
import com.cts.demo.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRespository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    public User saveUser(User user) {
        return user;
    }

    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }
}