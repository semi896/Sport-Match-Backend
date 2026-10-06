package com.example.Sportmatch.Service;

import com.example.Sportmatch.Entity.UsuarioEntity;
import java.util.List;

public interface UsuarioService {
    List listarActivos();
    UsuarioEntity registrar(UsuarioEntity usuario);
    UsuarioEntity buscarPorEmail(String email);
}