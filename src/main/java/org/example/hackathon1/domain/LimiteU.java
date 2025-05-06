package org.example.hackathon1.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.sparky.entity.Usuario;

@Entity
@Table(name = "limites_usuario")
@Getter
@Setter
@NoArgsConstructor
public class LimiteU{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private com.sparky.entity.Usuario usuario;

    @ManyToOne
    private com.sparky.entity.Restriccion restriccion;

    private int valorEspecifico;
}