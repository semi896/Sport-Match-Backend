package com.example.Sportmatch.Repository;

import com.example.Sportmatch.Entity.AuditoriaEntity;
import com.example.Sportmatch.Entity.ParticipacionEntity;
import com.example.Sportmatch.Entity.ParticipacionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipacionRepository extends JpaRepository <ParticipacionEntity,ParticipacionId>{

    // Listar las participaciones de un jugador
    @Query(value = "SELECT * FROM public.participacion WHERE usuario_id = :jugadorId", nativeQuery = true)
    List<ParticipacionEntity> listar_por_jugador(@Param("jugadorId") Long jugadorId);

    // Listar participantes confirmados en una actividad
    @Query(value = "SELECT * FROM public.participacion WHERE actividad_id = :actividadId AND estado = 'Confirmado'", nativeQuery = true)
    List<ParticipacionEntity> listar_participantes_confirmados(@Param("actividadId") Long actividadId);

    // Contar cuántos jugadores confirmados hay en un partido
    @Query(value = "SELECT COUNT(*) FROM public.participacion WHERE actividad_id = :actividadId AND estado = 'Confirmado'", nativeQuery = true)
    Long contar_confirmados(@Param("actividadId") Long actividadId);
}
