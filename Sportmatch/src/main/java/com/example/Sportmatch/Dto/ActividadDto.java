package com.example.Sportmatch.Dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class ActividadDto {
    private Long actividadId;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaHora;
    private Integer cupos;
    private String estado;
    private String nombreDeporte;
    private String nombreOrganizacion;
    private String direccionUbicacion;
}
