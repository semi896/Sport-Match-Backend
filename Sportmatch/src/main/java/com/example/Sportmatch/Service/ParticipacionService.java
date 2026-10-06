package com.example.Sportmatch.Service;

import com.example.Sportmatch.Entity.ParticipacionEntity;
import java.util.List;

public interface ParticipacionService {
    List<ParticipacionEntity> listarPorActividad(Long actividadId);
    List<ParticipacionEntity> listarPorJugador(Long jugadorId);
    ParticipacionEntity unirse(ParticipacionEntity participacion);
}
