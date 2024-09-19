package com.cts.neuro.neurouserservice.controller;

import com.cts.neuro.neurouserservice.exception.UserExceptionHandler;
import com.cts.neuro.neurouserservice.model.UserModel;
import com.cts.neuro.neurouserservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "User Management System", description = "Operations pertaining to user in User Management System")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @Operation(summary = "Returns all users in DB")
    public List<UserModel> AllUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Returns user with specific Id")
    public ResponseEntity<?> getUser(@PathVariable String id) throws UserExceptionHandler {

        return ResponseEntity.ok().body(userService.getUser(id));
    }

    @PostMapping("/register")
    @Operation(summary = "creates a new user in DB after validation")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserModel user) {
        try {

            return ResponseEntity.ok().body(userService.saveUser(user));
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Updates user with specific id")
    public ResponseEntity<?> UpdateUser(@Valid @RequestBody UserModel user, @PathVariable String id) throws UserExceptionHandler {
        return ResponseEntity.ok().body(userService.updateUser(user, id));
    }

}
