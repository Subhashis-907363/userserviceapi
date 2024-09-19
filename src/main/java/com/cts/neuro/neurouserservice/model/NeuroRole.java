package com.cts.neuro.neurouserservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "role")
public class NeuroRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String role_name;

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    private Set<UserModel> roles;

}
