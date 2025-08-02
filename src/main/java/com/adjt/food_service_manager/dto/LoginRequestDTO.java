package com.adjt.food_service_manager.dto;

import lombok.Getter;

@Getter
public record LoginRequestDTO(
        String login,
        String senha
) {

}
