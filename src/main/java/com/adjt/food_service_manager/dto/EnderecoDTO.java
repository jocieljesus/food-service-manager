package com.adjt.food_service_manager.dto;

public record EnderecoDTO(
        String logradouro,
        int numero,
        String bairro,
        String cidade,
        String estado,
        String cep
) {}