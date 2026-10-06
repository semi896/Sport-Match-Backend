package com.example.Sportmatch.Service.Impl;

import com.example.Sportmatch.Dto.ActividadDto;
import com.example.Sportmatch.Entity.ActividadEntity;
import com.example.Sportmatch.Repository.ActividadRepository;
import com.example.Sportmatch.Service.ActividadDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActividadDtoServiceImpl implements ActividadDtoService {

    @Autowired
    private ActividadRepository actividadRepository;

    @Override
    public List listarActividadesDto() {
        List listaRaw = actividadRepository.listar_actividades_disponibles();
        List dtos = new ArrayList<>();

        if (listaRaw != null) {
            for (Object obj : listaRaw) {
                if (obj instanceof ActividadEntity) {
                    ActividadEntity entidad = (ActividadEntity) obj;

                    ActividadDto dto = new ActividadDto();
                    dto.setActividadId(entidad.getActividadId());
                    dto.setNombre(entidad.getNombre());
                    dto.setDescripcion(entidad.getDescripcion());
                    dto.setFechaHora(entidad.getFechaHora());
                    dto.setCupos(entidad.getCupos());
                    dto.setEstado(entidad.getEstado());

                    if (entidad.getDeporte() != null) {
                        dto.setNombreDeporte(entidad.getDeporte().getNombre());
                    }
                    if (entidad.getOrganizador() != null) {
                        dto.setNombreOrganizacion(entidad.getOrganizador().getOrganizacion());
                    }
                    if (entidad.getUbicacion() != null) {
                        dto.setDireccionUbicacion(entidad.getUbicacion().getDireccion());
                    }

                    dtos.add(dto);
                }
            }
        }
        return dtos;
    }
}