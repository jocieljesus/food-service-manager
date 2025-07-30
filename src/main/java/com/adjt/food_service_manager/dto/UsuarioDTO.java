package com.adjt.food_service_manager.dto;

import com.adjt.food_service_manager.enums.TipoUsuarioEnum;
import java.util.Date;

public record UsuarioDTO(
        Long id,
        String nome,
        String email,
        String login,
        String senha,
        Date dtUltimaAlteracao,
        TipoUsuarioEnum tipoUsuarioEnum,
        EnderecoDTO endereco
) {}