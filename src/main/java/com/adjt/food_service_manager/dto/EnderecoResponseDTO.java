package com.adjt.food_service_manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EnderecoResponseDTO(

        String logradouro,
        String numero,
        String bairro,
        String cidade,
        String estado,
        String cep
) {}