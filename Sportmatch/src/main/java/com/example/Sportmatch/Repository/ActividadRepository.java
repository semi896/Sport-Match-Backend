package com.example.Sportmatch.Repository;

import com.example.Sportmatch.Entity.ActividadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActividadRepository extends JpaRepository <ActividadEntity,Long>{

    // OJO AQUÍ: Debe ser List, no solo List
    @Query(value = "SELECT * FROM public.actividad WHERE estado = 'Disponible'", nativeQuery = true)
    List<ActividadEntity> listar_actividades_disponibles();

    @Query(value = "SELECT * FROM public.actividad WHERE usuario_id = :organizadorId", nativeQuery = true)
    List<ActividadEntity> listar_por_organizador(@Param("organizadorId") Long organizadorId);

    @Query(value = "SELECT * FROM public.actividad WHERE deporte_id = :deporteId AND estado = 'Disponible'", nativeQuery = true)
    List<ActividadEntity> filtrar_por_deporte(@Param("deporteId") Long deporteId);
}
