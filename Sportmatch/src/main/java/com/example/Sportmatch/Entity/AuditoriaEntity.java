package com.example.Sportmatch.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "auditoria")
@Getter
@Setter
public class AuditoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auditoria_id")
    private Long auditoriaId;

    @Column(name = "accion")
    private String accion;

    @Column(name = "tabla")
    private String tabla;

    @Column(name = "registro_id")
    private Integer registroId;

    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private UsuarioEntity usuario;
}