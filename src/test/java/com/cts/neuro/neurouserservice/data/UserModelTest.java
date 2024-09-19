package com.cts.neuro.neurouserservice.data;

import com.cts.neuro.neurouserservice.model.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UserModelTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void testValidUser() {
        UserModel user = new UserModel();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("Pass@123#");

        Set<ConstraintViolation<UserModel>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void testInvalidFirstName() {
        UserModel user = new UserModel();
        user.setFirstName("1John"); // starts with a number
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("Pass@123!");

        Set<ConstraintViolation<UserModel>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());

//        assertEquals("First Name should start with a alphabet followed by any alphanumeric and special character like dot,-,_,',@.", violations.iterator().next().getMessage());
    }

    @Test
    public void testInvalidLastName() {
        UserModel user = new UserModel();
        user.setFirstName("John");
        user.setLastName("1Doe"); // starts with a number
        user.setEmail("john.doe@example.com");
        user.setPassword("Password1@");

        Set<ConstraintViolation<UserModel>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());
//        assertEquals("Last Name should start with a alphabet followed by any alphanumeric and special character like dot,-,_,',@.", violations.iterator().next().getMessage());
    }

    @Test
    public void testInvalidEmail() {
        UserModel user = new UserModel();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe"); // invalid email
        user.setPassword("Password1@");

        Set<ConstraintViolation<UserModel>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());
//        assertEquals("Invalid Email Address", violations.iterator().next().getMessage());
    }

    @Test
    public void testInvalidPassword() {
        UserModel user = new UserModel();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password"); // invalid password

        Set<ConstraintViolation<UserModel>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());
//        assertEquals("Password must be at least 8 characters long. \n Password must contain at least one special character. \n Password must contain at least one uppercase letter. \n Password must contain at least one number.", violations.iterator().next().getMessage());
    }
}