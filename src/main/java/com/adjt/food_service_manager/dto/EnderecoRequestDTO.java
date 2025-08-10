package com.adjt.food_service_manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EnderecoRequestDTO(

        @NotBlank(message = "Logradouro é obrigatório")
        @Size(max = 100)
        String logradouro,
        @NotBlank(message = "Número é obrigatório")
        String numero,
        @NotBlank(message = "Número é obrigatório")
        @Size(max = 100)
        String bairro,
        @NotBlank(message = "Cidade é obrigatória")
        @Size(max = 100)
        String cidade,
        @NotBlank(message = "Estado é obrigatória")
        @Size(max = 100)
        String estado,
        @NotBlank(message = "CEP é obrigatória")
        @Size(max = 100)
        String cep
) {}