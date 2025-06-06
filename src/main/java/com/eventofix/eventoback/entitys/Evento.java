package com.eventofix.eventoback.entitys;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "eventos")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evento_id")
    private Long eventoId;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDateTime fechaFin;

    @Column(name = "locacion")
    private String locacion;
    @Column(name = "organizador_id", nullable = false)
    private Long organizadorId;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "estado")
    private String estado = "planificado";
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizador_id", insertable = false, updatable = false)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "eventos" })
    private Usuario organizador;
}
