package com.cts.neuro.neurouserservice.service;

import com.cts.neuro.neurouserservice.exception.UserExceptionHandler;
import com.cts.neuro.neurouserservice.model.UserModel;
import com.cts.neuro.neurouserservice.repository.UserRepository;
import com.cts.neuro.neurouserservice.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        UserModel user1 = new UserModel();
        UserModel user2 = new UserModel();
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<UserModel> result = userService.getAllUser();

        assertEquals(2, result.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testGetUser() throws UserExceptionHandler {
        UserModel user = new UserModel();
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        UserModel result = userService.getUser("1");

        assertEquals(user, result);
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    public void testGetUserNotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(UserExceptionHandler.class, () -> userService.getUser("1"));
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    public void testSaveUser() {
        UserModel user = new UserModel();
        user.setPassword("password");
        when(bCryptPasswordEncoder.encode("password")).thenReturn("hashedPassword");
        when(userRepository.save(user)).thenReturn(user);

        UserModel result = userService.saveUser(user);

//        assertEquals("hashedPassword", result.getPassword());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testUpdateUser() throws UserExceptionHandler {
        UserModel user = new UserModel();
        UserModel existingUser = new UserModel();
        when(userRepository.findById(1L)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(existingUser)).thenReturn(existingUser);

        UserModel result = userService.updateUser(user, "1");

        assertEquals(existingUser, result);
        verify(userRepository, times(1)).findById(1L);
        verify(userRepository, times(1)).save(existingUser);
    }

    @Test
    public void testUpdateUserNotFound() {
        UserModel user = new UserModel();
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(UserExceptionHandler.class, () -> userService.updateUser(user, "1"));
        verify(userRepository, times(1)).findById(1L);
    }
}