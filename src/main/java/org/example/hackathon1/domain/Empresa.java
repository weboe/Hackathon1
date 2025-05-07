package org.example.hackathon1.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String ruc;

    @Column(nullable = false)
    private LocalDate fechaAfiliacion;

    @Column(nullable = false)
    private Boolean estadoActivo;

    @OneToOne
    private User administrador;

    @OneToMany(mappedBy = "usuarios_empresa")
    private List<User> usuarios;

    @OneToMany
    private List<Restriccion> restricciones;

    public boolean isEstadoActivo() {
        return estadoActivo;
    }

    public void setEstadoActivo(boolean estadoActivo) {
        this.estadoActivo = estadoActivo;
    }
}
