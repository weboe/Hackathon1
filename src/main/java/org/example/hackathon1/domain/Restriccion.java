package com.sparky.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "restricciones")
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

    private int valorLimite;
    private int ventanaTiempoMinutos;

    @ManyToOne
    private Empresa empresa;

    @OneToMany(mappedBy = "restriccion")
    private List<LimiteUsuario> limitesUsuario;
}
