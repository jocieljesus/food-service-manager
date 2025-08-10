package com.adjt.food_service_manager.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginResponseDTO(
        @Schema(description = "Indica se a autenticação foi bem-sucedida")
        boolean autenticado,

        @Schema(description = "Mensagem de retorno da autenticação")
        String mensagem,

        @Schema(description = "Nome do usuário autenticado")
        String nomeUsuario
) {}
