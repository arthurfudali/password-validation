package com.dev.secure_password.dtos;

import java.util.List;

public record PasswordResponseDTO(
        String status,
        List<String> errors
) {
}
