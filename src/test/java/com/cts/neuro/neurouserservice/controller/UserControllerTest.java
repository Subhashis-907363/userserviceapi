package com.cts.neuro.neurouserservice.controller;

import com.cts.neuro.neurouserservice.exception.UserExceptionHandler;
import com.cts.neuro.neurouserservice.model.UserModel;
import com.cts.neuro.neurouserservice.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        UserModel user1 = new UserModel();
        UserModel user2 = new UserModel();
        when(userService.getAllUser()).thenReturn(Arrays.asList(user1, user2));

        List<UserModel> result = userController.AllUsers();

        assertEquals(2, result.size());
        verify(userService, times(1)).getAllUser();
    }

    @Test
    public void testGetUser() throws UserExceptionHandler {
        UserModel user = new UserModel();
        when(userService.getUser("1")).thenReturn(user);

        ResponseEntity<?> result = userController.getUser("1");

        assertEquals(user, result.getBody());
        verify(userService, times(1)).getUser("1");
    }

    @Test
    public void testGetUserNotFound() throws UserExceptionHandler {
        when(userService.getUser("1")).thenThrow(new UserExceptionHandler("User not found"));

        assertThrows(UserExceptionHandler.class, () -> userController.getUser("1"));
        verify(userService, times(1)).getUser("1");
    }

    @Test
    public void testRegisterUser() {
        UserModel user = new UserModel();
        when(userService.saveUser(user)).thenReturn(user);

        ResponseEntity<?> result = userController.registerUser(user);

        assertEquals(user, result.getBody());
        verify(userService, times(1)).saveUser(user);
    }

    @Test
    public void testRegisterUserFailure() {
        UserModel user = new UserModel();
        when(userService.saveUser(user)).thenThrow(new RuntimeException("Failed to register user"));

        ResponseEntity<?> result = userController.registerUser(user);

        assertEquals("Failed to register user", result.getBody());
        verify(userService, times(1)).saveUser(user);
    }

    @Test
    public void testUpdateUser() throws UserExceptionHandler {
        UserModel user = new UserModel();
        when(userService.updateUser(user, "1")).thenReturn(user);

        ResponseEntity<?> result = userController.UpdateUser(user, "1");

        assertEquals(user, result.getBody());
        verify(userService, times(1)).updateUser(user, "1");
    }

    @Test
    public void testUpdateUserFailure() throws UserExceptionHandler {
        UserModel user = new UserModel();
        when(userService.updateUser(user, "1")).thenThrow(new UserExceptionHandler("Failed to update user"));

        assertThrows(UserExceptionHandler.class, () -> userController.UpdateUser(user, "1"));
        verify(userService, times(1)).updateUser(user, "1");
    }
}