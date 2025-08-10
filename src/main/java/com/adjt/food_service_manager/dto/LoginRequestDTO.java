package com.adjt.food_service_manager.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(
        @NotBlank(message = "Login é obrigatório")
        @Schema(example = "admin")
        String login,

        @NotBlank(message = "Senha é obrigatória")
        @Schema(example = "senha123")
        String senha
) {}