package com.adjt.food_service_manager.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adjt.food_service_manager.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByLogin (String login);
    Optional<UsuarioModel> findByEmail(String email);
}
