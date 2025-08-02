package com.adjt.food_service_manager.mapper;

import com.adjt.food_service_manager.dto.*;
import com.adjt.food_service_manager.model.EnderecoModel;
import com.adjt.food_service_manager.model.UsuarioModel;

import java.time.LocalDateTime;

public class UsuarioMapper {

    public static UsuarioModel toEntity(UsuarioRequestDTO dto) {
        if (dto == null) return null;

        return UsuarioModel.builder()
                .nome(dto.nome())
                .email(dto.email())
                .login(dto.login())
                .senha(dto.senha())
                .dtUltimaAlteracao(LocalDateTime.now())
                .tipoUsuarioEnum(dto.tipoUsuarioEnum())
                .endereco(toEnderecoEntity(dto.endereco()))
                .build();
    }

    private static EnderecoModel toEnderecoEntity(EnderecoRequestDTO dto) {
        if (dto == null) return null;

        return EnderecoModel.builder()
                .logradouro(dto.logradouro())
                .numero(dto.numero())
                .bairro(dto.bairro())
                .cidade(dto.cidade())
                .estado(dto.estado())
                .cep(dto.cep())
                .build();
    }

    public static UsuarioResponseDTO toResponseDTO(UsuarioModel model) {
        if (model == null) return null;

        return new UsuarioResponseDTO(
                model.getId(),
                model.getNome(),
                model.getEmail(),
                model.getLogin(),
                model.getDtUltimaAlteracao(),
                model.getTipoUsuarioEnum(),
                toEnderecoResponseDTO(model.getEndereco())
        );
    }

    public static EnderecoResponseDTO toEnderecoResponseDTO(EnderecoModel model) {
        if (model == null) return null;

        return new EnderecoResponseDTO(
                model.getLogradouro(),
                model.getNumero(),
                model.getBairro(),
                model.getCidade(),
                model.getEstado(),
                model.getCep()
        );
    }
}