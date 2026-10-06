package com.example.Sportmatch.Repository;

import com.example.Sportmatch.Entity.AuditoriaEntity;
import com.example.Sportmatch.Entity.JugadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository <JugadorEntity,Long>{

    @Query(value = "SELECT * FROM public.jugador WHERE estado = 'Activo'", nativeQuery = true)
    List<JugadorEntity> listar_jugadores_activos();

    @Query(value = "SELECT * FROM public.jugador WHERE nivel = :nivel", nativeQuery = true)
    List<JugadorEntity> listar_por_nivel(@Param("nivel") String nivel);
}
