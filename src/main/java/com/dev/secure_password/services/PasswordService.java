package com.dev.secure_password.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordService {

    public boolean validatePassword(String password) {
        // regex
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%]).{8,}$";
        return password.matches(pattern);
    }

    public List<String> validate(String password) {

        List<String> falhas = new ArrayList<>();

        // Verificação de Maiúsculas
        if (!password.matches(".*[A-Z].*")) {
            falhas.add("Falta pelo menos uma letra maiúscula.");
        }

        // Verificação de Minúsculas
        if (!password.matches(".*[a-z].*")) {
            falhas.add("Falta pelo menos uma letra minúscula.");
        }

        // Verificação de Números
        if (!password.matches(".*[0-9].*")) {
            falhas.add("Falta pelo menos um número.");
        }

        // Verificação de Caracteres Especiais
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            falhas.add("Falta pelo menos um caractere especial (!@#$...).");
        }

        // Verificação de Tamanho Mínimo
        if (password.length() < 8) {
            falhas.add("A senha deve ter pelo menos 8 caracteres.");
        }

        return falhas;
    }
}
