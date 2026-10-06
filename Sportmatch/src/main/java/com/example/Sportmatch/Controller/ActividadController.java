package com.example.Sportmatch.Controller;

import com.example.Sportmatch.Entity.ActividadEntity;
import com.example.Sportmatch.Service.ActividadDtoService;
import com.example.Sportmatch.Service.ActividadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("actividades")
@Tag(name = "Controlador de Actividad", description = "Controlador para gestionar la publicacion y busqueda de partidos deportivos")
public class ActividadController {

    @Autowired
    private ActividadService service;

    @Autowired
    private ActividadDtoService serviceDto;

    @GetMapping("listar_disponibles")
    @Operation(summary = "Listar actividades deportivas disponibles en formato entidad")
    public List listar_actividades() {
        List listar_nuevo = new ArrayList<>();
        listar_nuevo = service.listar();
        return listar_nuevo;
    }

    @GetMapping("listar_dto")
    @Operation(summary = "Listar actividades en formato DTO sin relaciones pesadas")
    public List listar_actividades_dto() {
        List listar_nuevo = new ArrayList<>();
        listar_nuevo = serviceDto.listarActividadesDto();
        return listar_nuevo;
    }

    @GetMapping("deporte/{deporteId}")
    @Operation(summary = "Filtrar actividades por deporte")
    public List filtrar_por_deporte(@PathVariable Long deporteId) {
        return service.filtrarPorDeporte(deporteId);
    }

    @GetMapping("{id}")
    @Operation(summary = "Obtener el detalle de una actividad por ID")
    public ActividadEntity obtener_actividad(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping("registrar")
    @Operation(summary = "Registrar y publicar una nueva actividad deportiva")
    public ActividadEntity registrar_actividad(@RequestBody ActividadEntity actividad) {
        return service.registrar(actividad);
    }
}