package com.adjt.food_service_manager.dto;

import com.adjt.food_service_manager.enums.TipoUsuarioEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record UsuarioRequestDTO(

        String nome,
        String email,
        String login,
        String senha,
        TipoUsuarioEnum tipoUsuarioEnum,
        EnderecoRequestDTO endereco
) {}