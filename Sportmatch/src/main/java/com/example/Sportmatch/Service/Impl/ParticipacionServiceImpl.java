package com.example.Sportmatch.Service.Impl;

import com.example.Sportmatch.Entity.ParticipacionEntity;
import com.example.Sportmatch.Entity.ParticipacionId;
import com.example.Sportmatch.Repository.ParticipacionRepository;
import com.example.Sportmatch.Service.ParticipacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ParticipacionServiceImpl implements ParticipacionService {

    @Autowired
    private ParticipacionRepository participacionRepository;

    @Override
    public List<ParticipacionEntity> listarPorActividad(Long actividadId) {
        return participacionRepository.listar_participantes_confirmados(actividadId);
    }

    @Override
    public List<ParticipacionEntity> listarPorJugador(Long jugadorId) {
        return participacionRepository.listar_por_jugador(jugadorId);
    }

    @Override
    public ParticipacionEntity unirse(ParticipacionEntity participacion) {
        if (participacion.getId() == null) {
            ParticipacionId nuevoId = new ParticipacionId();

            if (participacion.getActividad() != null) {
                nuevoId.setActividadId(participacion.getActividad().getActividadId());
            }
            if (participacion.getJugador() != null) {
                // Usa getUsuarioId() o getJugadorId() según cómo esté en JugadorEntity
                nuevoId.setUsuarioId(participacion.getJugador().getUsuarioId());
            }

            participacion.setId(nuevoId);
        }

        if (participacion.getFechaInscripcion() == null) {
            participacion.setFechaInscripcion(LocalDateTime.now());
        }

        return participacionRepository.save(participacion);
    }
}
