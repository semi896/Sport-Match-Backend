package com.example.Sportmatch.Repository;

import com.example.Sportmatch.Entity.AuditoriaEntity;
import com.example.Sportmatch.Entity.OrganizadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizadorRepository extends JpaRepository <OrganizadorEntity,Long>{

    @Query(value = "SELECT * FROM public.organizador WHERE estado = 'Activo'", nativeQuery = true)
    List<OrganizadorEntity> listar_organizadores_activos();
}
