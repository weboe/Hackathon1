package org.example.hackathon1.infrastructure;

import org.example.hackathon1.domain.Empresa;
import org.example.hackathon1.domain.Restriccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestriccionRepository extends JpaRepository<Restriccion, Long> {
    List<Restriccion> findByEmpresa(Empresa empresa);
    List<Restriccion> findByEmpresaId(Long empresaId);
}
