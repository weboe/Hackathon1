package org.example.hackathon1.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "limiteUsuario")
@Getter
@Setter
@NoArgsConstructor
public class LimiteUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int limite; // Límite de uso (ejemplo: tokens)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    private Restriccion restriccion; // Restricción que define el límite

    @Column(nullable = false)
    private int valorEspecifico;

    public void setUserId(Long userId) {
        this.user = new User(userId);
    }

}
