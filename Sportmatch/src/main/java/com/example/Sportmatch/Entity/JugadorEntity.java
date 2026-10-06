package com.example.Sportmatch.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "jugador")
@Getter
@Setter
public class JugadorEntity {

    @Id
    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "nivel")
    private String nivel;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

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
