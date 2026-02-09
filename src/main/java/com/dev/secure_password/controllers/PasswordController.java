package com.dev.secure_password.controllers;

import com.dev.secure_password.dtos.PasswordRequestDTO;
import com.dev.secure_password.dtos.PasswordResponseDTO;
import com.dev.secure_password.services.PasswordService;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PasswordController {

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping("/validate-password")
    public ResponseEntity<@NonNull PasswordResponseDTO> validatePassword(@RequestBody PasswordRequestDTO passwordRequestDTO) {
        List<String> errors = passwordService.validatePasswordRegex(passwordRequestDTO.password());
        if (errors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        PasswordResponseDTO response = new PasswordResponseDTO(
                "Invalid password",
                errors
        );
        return ResponseEntity.badRequest().body(response);
    }
}
