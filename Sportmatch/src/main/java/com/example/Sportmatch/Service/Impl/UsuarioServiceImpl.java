package com.example.Sportmatch.Service.Impl;

import com.example.Sportmatch.Entity.UsuarioEntity;
import com.example.Sportmatch.Repository.UsuarioRepository;
import com.example.Sportmatch.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List listarActivos() {
        return usuarioRepository.listar_usuarios_activos();
    }

    @Override
    public UsuarioEntity registrar(UsuarioEntity usuario) {
        if (usuario.getFechaRegistro() == null) {
            usuario.setFechaRegistro(LocalDateTime.now());
        }
        if (usuario.getEstado() == null) {
            usuario.setEstado("Activo");
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}