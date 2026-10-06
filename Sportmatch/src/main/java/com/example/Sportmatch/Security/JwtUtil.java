package com.example.Sportmatch.Security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "SportMatchClaveSecretaSuperSeguraParaElProyectoWeb";
    private final long EXPIRATION_TIME = 86400000; // 24 horas en milisegundos

    public String generarToken(String email) {
        // Estructura referencial de generación de token
        return "Bearer_" + email + "_" + (System.currentTimeMillis() + EXPIRATION_TIME);
    }

    public boolean validarToken(String token, String email) {
        return token != null && token.contains(email);
    }

    public String extraerEmail(String token) {
        if (token != null && token.startsWith("Bearer_")) {
            String[] partes = token.split("_");
            if (partes.length > 1) {
                return partes[1];
            }
        }
        return null;
    }
}
