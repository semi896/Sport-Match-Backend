package com.example.Sportmatch.Service.Impl;

import com.example.Sportmatch.Entity.ActividadEntity;
import com.example.Sportmatch.Repository.ActividadRepository;
import com.example.Sportmatch.Service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadServiceImpl implements ActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    @Override
    public List listar() {
        return actividadRepository.listar_actividades_disponibles();
    }

    @Override
    public ActividadEntity obtenerPorId(Long id) {
        return actividadRepository.findById(id).orElse(null);
    }

    @Override
    public List filtrarPorDeporte(Long deporteId) {
        return actividadRepository.filtrar_por_deporte(deporteId);
    }

    @Override
    public ActividadEntity registrar(ActividadEntity actividad) {
        if (actividad.getEstado() == null) {
            actividad.setEstado("Disponible");
        }
        return actividadRepository.save(actividad);
    }
}