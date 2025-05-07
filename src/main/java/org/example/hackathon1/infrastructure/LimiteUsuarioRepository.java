package org.example.hackathon1.infrastructure;

import org.example.hackathon1.domain.LimiteUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LimiteUsuarioRepository extends JpaRepository<LimiteUsuario, Long> {
    LimiteUsuario findByUserId(Long userId);
}
