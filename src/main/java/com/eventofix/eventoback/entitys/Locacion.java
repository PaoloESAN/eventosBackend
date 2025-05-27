package com.eventofix.eventoback.entitys;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "locaciones")
public class Locacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locacion_id")
    private Long locacionId;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "direccion", nullable = false, columnDefinition = "TEXT")
    private String direccion;

    @Column(name = "ciudad", nullable = false, length = 100)
    private String ciudad;

    @Column(name = "pais", nullable = false, length = 100)
    private String pais;

    @Column(name = "capacidad")
    private Integer capacidad;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;
}
