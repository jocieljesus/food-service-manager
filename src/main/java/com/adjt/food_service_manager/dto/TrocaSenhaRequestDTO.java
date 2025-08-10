package com.adjt.food_service_manager.dto;


public record TrocaSenhaRequestDTO(
        String login,
        String senha,
        String novaSenha
) {

}
