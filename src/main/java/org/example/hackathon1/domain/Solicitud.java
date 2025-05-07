package org.example.hackathon1.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "solicitud")
@Getter
@Setter
@NoArgsConstructor
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User usuario;

    @Enumerated(EnumType.STRING)
    private ModeloIA modelo;

    @Column(nullable = false)
    private String consulta;

    @Column(nullable = false)
    private String respuesta;

    @Column(nullable = false)
    private String error;

    @Column(nullable = false)
    private int tokensUsados; // Tokens usados en la consulta

    @Column(nullable = false)
    private LocalDateTime fechaHora;

    @Column(nullable = false, unique = true)
    private String NombreArchivo;
}
