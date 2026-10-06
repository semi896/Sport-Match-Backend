package com.example.Sportmatch.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "organizador")
@Getter
@Setter
public class OrganizadorEntity {

    @Id
    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "organizacion")
    private String organizacion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "estado")
    private String estado;

    @OneToOne
    @JoinColumn(
            name = "usuario_id",
            referencedColumnName = "usuario_id",
            insertable = false,
            updatable = false
    )
    private UsuarioEntity usuario;
}