package com.adjt.food_service_manager.dto;

public record LoginResponseDTO(
        boolean autenticado,
        String mensagem,
        String nomeUsuario
) {
}
