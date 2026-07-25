package com.igor.user_service.dto;

import jakarta.validation.constraints.NotBlank;

public record RegisterInput(@NotBlank String email) {


}
