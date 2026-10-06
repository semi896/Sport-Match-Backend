package com.example.Sportmatch.Repository;

import com.example.Sportmatch.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository <UsuarioEntity,Long>{

    UsuarioEntity findByEmail(String email);


    @Query(value = "SELECT * FROM public.usuario WHERE estado = 'Activo'", nativeQuery = true)
    List<UsuarioEntity> listar_usuarios_activos();
}
