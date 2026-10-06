package com.example.Sportmatch.Controller;

import com.example.Sportmatch.Entity.ParticipacionEntity;
import com.example.Sportmatch.Service.ParticipacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("participaciones")
@Tag(name = "Controlador de Participacion", description = "Controlador para gestionar la inscripcion de jugadores en actividades deportivas")
public class ParticipacionController {

    @Autowired
    private ParticipacionService service;

    @GetMapping("actividad/{actividadId}")
    @Operation(summary = "Listar los participantes confirmados de una actividad deportiva")
    public List listar_por_actividad(@PathVariable Long actividadId) {
        List listar_nuevo = new ArrayList<>();
        listar_nuevo = service.listarPorActividad(actividadId);
        return listar_nuevo;
    }

    @GetMapping("jugador/{jugadorId}")
    @Operation(summary = "Listar el historial de actividades e inscripciones de un jugador")
    public List listar_por_jugador(@PathVariable Long jugadorId) {
        List listar_nuevo = new ArrayList<>();
        listar_nuevo = service.listarPorJugador(jugadorId);
        return listar_nuevo;
    }

    @PostMapping("unirse")
    @Operation(summary = "Solicitar inscripcion en una actividad deportiva")
    public ParticipacionEntity unirse_actividad(@RequestBody ParticipacionEntity participacion) {
        return service.unirse(participacion);
    }
}