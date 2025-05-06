package org.example.hackathon1.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.hackathon1.domain.Usuario;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "empresa")
@Getter
@Setter
@NoArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String ruc;

    @Column(nullable = false)
    private LocalDate fechaAfiliacion;

    @Column(nullable = false)
    private Boolean estadoActivo;

    @OneToOne
    private Usuario administrador;

    @OneToMany(mappedBy = "usuarios-empresa")
    private List<Usuario> usuarios;

}
