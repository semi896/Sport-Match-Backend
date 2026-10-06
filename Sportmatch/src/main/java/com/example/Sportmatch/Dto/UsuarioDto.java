package com.example.Sportmatch.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {
    private Long usuarioId;
    private String nombre;
    private String email;
    private String estado;
}