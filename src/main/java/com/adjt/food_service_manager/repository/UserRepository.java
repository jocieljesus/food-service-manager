package com.adjt.food_service_manager.repository;


import com.adjt.food_service_manager.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByLogin (String login);
    Optional<UserModel> findByEmail(String email);
}
