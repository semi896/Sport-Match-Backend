package com.example.Sportmatch.Service;

import com.example.Sportmatch.Entity.ActividadEntity;
import java.util.List;

public interface ActividadService {
    List listar();
    ActividadEntity obtenerPorId(Long id);
    List filtrarPorDeporte(Long deporteId);
    ActividadEntity registrar(ActividadEntity actividad);
}