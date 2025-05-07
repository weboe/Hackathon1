package org.example.hackathon1.domain;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "restriccion")
@Getter
@Setter
@NoArgsConstructor
public class Restriccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ModeloIA modelo;

    @Enumerated(EnumType.STRING)
    private TipoLimite tipoLimite;

    @Column(nullable = false)
    private int valorLimite; //limite de uso x ejemplo de tokens

    @Column(nullable = false)
    private int ventanaTiempo; //ventana de tiempo en minutos

    @ManyToOne
    @JoinColumn(name = "empresa_id", referencedColumnName = "id", nullable = false)
    private Empresa empresa;

    @OneToMany(mappedBy = "restriccion")
    private List<LimiteUsuario> limitesUsuarios;
}
