package com.example.Sportmatch.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "participacion")
@Getter
@Setter
public class ParticipacionEntity {

    @EmbeddedId
    private ParticipacionId id;

    @Column(name = "fecha_inscripcion")
    private LocalDateTime fechaInscripcion;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(
            name = "usuario_id",
            referencedColumnName = "usuario_id",
            insertable = false,
            updatable = false
    )
    private JugadorEntity jugador;

    @ManyToOne
    @JoinColumn(
            name = "actividad_id",
            referencedColumnName = "actividad_id",
            insertable = false,
            updatable = false
    )
    private ActividadEntity actividad;
}
