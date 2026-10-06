package com.example.Sportmatch.Repository;

import com.example.Sportmatch.Entity.AuditoriaEntity;
import com.example.Sportmatch.Entity.DeporteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeporteRepository extends JpaRepository <DeporteEntity,Long>{

    DeporteEntity findByNombre(String nombre);

    @Query(value = "SELECT * FROM public.deporte ORDER BY nombre ASC", nativeQuery = true)
    List<DeporteEntity> listar_deportes_ordenados();
}
