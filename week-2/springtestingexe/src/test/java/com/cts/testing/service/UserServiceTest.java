package com.cts.testing.service;

import com.cts.demo.User;
import com.cts.demo.respository.UserRespository;
import com.cts.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRespository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void getUserById_shouldReturnUserWhenExists() {
        User mockUser = new User(1L, "John");
        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));

        User result = userService.getUserById(1L);
        assertEquals("John", result.getName());
    }

    @Test
    void getUserById_shouldThrowWhenNotExists() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class, () -> userService.getUserById(99L));
    }
}