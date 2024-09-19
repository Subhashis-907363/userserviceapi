package com.cts.neuro.neurouserservice.repository;

import com.cts.neuro.neurouserservice.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel,Long> {

}
