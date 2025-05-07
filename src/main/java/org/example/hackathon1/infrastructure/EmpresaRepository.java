package org.example.hackathon1.infrastructure;
import org.example.hackathon1.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    // Custom query methods can be defined here if needed
    // For example, to find by RUC:
    Optional<Empresa> findByRuc(String ruc);
    Optional<Empresa> findById(Long id);
    List<Empresa> findAll();
}
