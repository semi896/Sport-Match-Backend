package com.example.Sportmatch.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class ParticipacionId implements Serializable {

    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "actividad_id")
    private Long actividadId;
}