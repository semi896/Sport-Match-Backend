package com.example.Sportmatch.Service;

import com.example.Sportmatch.Dto.UsuarioDto;
import java.util.List;

public interface UsuarioDtoService {
    List listarUsuariosDto();
    UsuarioDto registrarUsuarioDto(UsuarioDto dto, String contrasena);
}