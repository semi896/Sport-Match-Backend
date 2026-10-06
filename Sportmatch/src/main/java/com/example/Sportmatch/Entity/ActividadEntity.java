package com.example.Sportmatch.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "actividad")
@Getter
@Setter
public class ActividadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actividad_id")
    private Long actividadId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;

    @Column(name = "cupos")
    private Integer cupos;

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private OrganizadorEntity organizador;

    @ManyToOne
    @JoinColumn(name = "deporte_id", referencedColumnName = "deporte_id")
    private DeporteEntity deporte;

    @ManyToOne
    @JoinColumn(name = "ubicacion_id", referencedColumnName = "ubicacion_id")
    private UbicacionEntity ubicacion;
}