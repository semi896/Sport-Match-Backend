package com.example.Sportmatch.Service.Impl;

import com.example.Sportmatch.Dto.UsuarioDto;
import com.example.Sportmatch.Entity.UsuarioEntity;
import com.example.Sportmatch.Repository.UsuarioRepository;
import com.example.Sportmatch.Service.UsuarioDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioDtoServiceImpl implements UsuarioDtoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List listarUsuariosDto() {
        List listaGenerica = usuarioRepository.listar_usuarios_activos();
        List dtos = new ArrayList<>();

        if (listaGenerica != null) {
            for (Object obj : listaGenerica) {
                if (obj instanceof UsuarioEntity) {
                    UsuarioEntity entidad = (UsuarioEntity) obj;
                    UsuarioDto dto = new UsuarioDto();
                    dto.setUsuarioId(entidad.getUsuarioId());
                    dto.setNombre(entidad.getNombre());
                    dto.setEmail(entidad.getEmail());
                    dto.setEstado(entidad.getEstado());
                    dtos.add(dto);
                }
            }
        }
        return dtos;
    }

    @Override
    public UsuarioDto registrarUsuarioDto(UsuarioDto dto, String contrasena) {
        UsuarioEntity entidad = new UsuarioEntity();
        entidad.setNombre(dto.getNombre());
        entidad.setEmail(dto.getEmail());
        entidad.setContrasena(contrasena);
        entidad.setFechaRegistro(LocalDateTime.now());
        entidad.setEstado(dto.getEstado() != null ? dto.getEstado() : "Activo");


        UsuarioEntity guardado = usuarioRepository.save(entidad);

        UsuarioDto resultado = new UsuarioDto();
        resultado.setUsuarioId(guardado.getUsuarioId());
        resultado.setNombre(guardado.getNombre());
        resultado.setEmail(guardado.getEmail());
        resultado.setEstado(guardado.getEstado());
        return resultado;
    }
}
