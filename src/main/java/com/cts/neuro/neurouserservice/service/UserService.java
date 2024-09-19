package com.cts.neuro.neurouserservice.service;

import com.cts.neuro.neurouserservice.exception.UserExceptionHandler;
import com.cts.neuro.neurouserservice.model.UserModel;
import com.cts.neuro.neurouserservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserModel> getAllUser() {
        return userRepository.findAll();
    }

    public UserModel getUser(String id) throws UserExceptionHandler {
        System.err.println("id: " + id);
        Long Id = Long.parseLong(id);
        Optional<UserModel> user = userRepository.findById(Id);
        if (!user.isPresent()) {
            throw new UserExceptionHandler("User with id not found." + id);
        }

        return user.get();
    }

    public UserModel saveUser(UserModel user) {
//        Validator validator = ValidationUtil.getValidator();
//        Set<ConstraintViolation<UserModel>> violations = validator.validate(user);
//        if (!violations.isEmpty()) {
//            StringBuilder sb = new StringBuilder();
//            for (ConstraintViolation<UserModel> constraintViolation : violations) {
//                sb.append(constraintViolation.getMessage());
//            }
//            System.out.println("######## ");
//            throw new ConstraintViolationException(sb.toString(), violations);
//        }
        String password = user.getPassword();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    public UserModel updateUser(UserModel user, String id) throws UserExceptionHandler {
        Long Id = Long.parseLong(id);
        try {
            Optional<UserModel> existingUser = userRepository.findById(Id);
            if (existingUser.isPresent()) {
                UserModel modifiedUser=existingUser.get();
                modifiedUser.setEmail(user.getEmail());
                modifiedUser.setRoles(user.getRoles());
                modifiedUser.setPassword(user.getPassword());
                modifiedUser.setLastName(user.getLastName());
                modifiedUser.setFirstName(user.getFirstName());
                userRepository.save(modifiedUser);
                return modifiedUser;
            }else {
                throw new UserExceptionHandler(MessageFormat.format("User with id {0} not found.", id));
            }

        } catch (Exception e) {
            throw new UserExceptionHandler(MessageFormat.format("User with email {0} not found.", user.getEmail()));

        }

    }

}
