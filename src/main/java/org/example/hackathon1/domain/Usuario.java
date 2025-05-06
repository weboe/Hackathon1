package com.sparky.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hackathon1.domain.Empresa;

import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Rol rol; // Rol del usuario (SPARKY_ADMIN, COMPANY_ADMIN, USER)

    @ManyToOne
    private Empresa empresa; // Relación con la empresa a la que pertenece el usuario

    //@OneToMany(mappedBy = "usuario")
    //private List<LimiteUsuario> limites; // Límites específicos de usuario

    //@OneToMany(mappedBy = "usuario")
    //private List<Solicitud> solicitudes; // Historial de solicitudes de IA realizadas por el usuario
}