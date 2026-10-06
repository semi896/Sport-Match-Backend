package com.example.Sportmatch.Repository;

import com.example.Sportmatch.Entity.AuditoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditoriaRepository extends JpaRepository <AuditoriaEntity,Long>{

    @Query(value = "SELECT * FROM public.auditoria WHERE usuario_id = :usuarioId", nativeQuery = true)
    List<AuditoriaEntity> listar_por_usuario(@Param("usuarioId") Long usuarioId);
}
