package com.eventofix.eventoback.entitys;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "asistentes_evento")
public class AsistenteEvento {

    @EmbeddedId
    private AsistenteEventoId id;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @Column(name = "asistio")
    private Boolean asistio = false;

    @Column(name = "feedback", columnDefinition = "TEXT")
    private String feedback;

    @Column(name = "calificacion")
    private Integer calificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evento_id", insertable = false, updatable = false)
    private Evento evento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private Usuario usuario;

    @Embeddable
    @Data
    public static class AsistenteEventoId implements java.io.Serializable {
        @Column(name = "evento_id")
        private Long eventoId;

        @Column(name = "usuario_id")
        private Long usuarioId;
    }
}
