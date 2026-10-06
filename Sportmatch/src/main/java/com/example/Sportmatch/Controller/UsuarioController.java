package com.example.Sportmatch.Controller;

import com.example.Sportmatch.Entity.UsuarioEntity;
import com.example.Sportmatch.Service.UsuarioDtoService;
import com.example.Sportmatch.Service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("usuarios")
@Tag(name = "Controlador de Usuario", description = "Controlador para gestionar el registro y consulta de usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private UsuarioDtoService serviceDto;

    @GetMapping("listar_usuarios")
    @Operation(summary = "Listar todos los usuarios activos")
    public List listar_usuarios() {
        List listar_nuevo = new ArrayList<>();
        listar_nuevo = service.listarActivos();
        return listar_nuevo;
    }

    @GetMapping("listar_dto")
    @Operation(summary = "Listar usuarios sin exponer credenciales")
    public List listar_usuarios_dto() {
        List listar_nuevo = new ArrayList<>();
        listar_nuevo = serviceDto.listarUsuariosDto();
        return listar_nuevo;
    }

    @PostMapping("registrar")
    @Operation(summary = "Registrar una nueva cuenta de usuario")
    public UsuarioEntity registrar_usuario(@RequestBody UsuarioEntity usuario) {
        return service.registrar(usuario);
    }

    @PostMapping("login")
    @Operation(summary = "Autenticacion de usuario por correo y contrasena")
    public UsuarioEntity login(@RequestBody UsuarioEntity loginData) {
        UsuarioEntity user = service.buscarPorEmail(loginData.getEmail());
        if (user != null && user.getContrasena().equals(loginData.getContrasena())) {
            return user;
        }
        return null;
    }
}