package com.adjt.food_service_manager.dto;

import java.util.List;

public record ValidationErrorDTO(List<String> errors, int status) {
}