package com.cts.neuro.neurouserservice.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Length(min = 2, max = 100, message = "First Name should be between 2 and 100 characters")
    @Pattern(regexp = "^[A-Za-z][-A-Za-z\\d\\s._'@][-A-Za-z\\d\\s._'@]*$", message = "First Name should start with a alphabet followed by any alphanumeric and special character like dot,-,_,',@.")
    @Column(name = "first_name")
    private String firstName;

    @Length(min = 2, max = 100, message = "Last Name should be between 2 and 100 characters")
    @Pattern(regexp = "^[A-Za-z][-A-Za-z\\d\\s._'@][-A-Za-z\\d\\s._'@]*$", message = "Last Name should start with a alphabet followed by any alphanumeric and special character like dot,-,_,',@.")
    @Column(name = "last_name")
    private String lastName;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Enter valid email address.")
    @Column(name = "email", unique = true)
    private String email;


    @Pattern(regexp = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$",message = "Password must be at least 8 characters long. \n Password must contain at least one special character. \n Password must contain at least one uppercase letter. \n Password must contain at least one number.")
    @Column(name = "password")
    private String password;

    @NotNull
    @NotEmpty(message = "Role cannot be empty")
    @Column(name = "role")
    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<NeuroRole> roles;
}
