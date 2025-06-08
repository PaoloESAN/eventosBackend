package com.eventofix.eventoback.entitys;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long ticketId;

    @Column(name = "evento_id", nullable = false)
    private Long eventoId;

    @Column(name = "tipo_ticket", nullable = false, length = 100)
    private String tipoTicket;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "cantidad_disponible", nullable = false)
    private Integer cantidadDisponible;

    @Column(name = "fecha_inicio_venta")
    private LocalDateTime fechaInicioVenta;
    @Column(name = "fecha_fin_venta")
    private LocalDateTime fechaFinVenta;

    @Column(name = "cantidad_total", nullable = false)
    private Integer cantidadTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evento_id", insertable = false, updatable = false)
    private Evento evento;
}
