package com.adjt.food_service_manager.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adjt.food_service_manager.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByLogin (String login);
    Optional<UserModel> findByEmail(String email);
}
