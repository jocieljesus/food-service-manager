package com.adjt.food_service_manager.dto;

import com.adjt.food_service_manager.enums.TipoUsuarioEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record UsuarioResponseDTO(

        Long id,
        String nome,
        String email,
        String login,
        LocalDateTime dtUltimaAlteracao,
        TipoUsuarioEnum tipoUsuarioEnum,
        EnderecoResponseDTO endereco
) {}