package com.example.Sportmatch.Repository;

import com.example.Sportmatch.Entity.AuditoriaEntity;
import com.example.Sportmatch.Entity.UbicacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UbicacionRepository extends JpaRepository <UbicacionEntity,Long>{

    @Query(value = "SELECT * FROM public.ubicacion WHERE ciudad = :ciudad", nativeQuery = true)
    List<UbicacionEntity> listar_por_ciudad(@Param("ciudad") String ciudad);
}
