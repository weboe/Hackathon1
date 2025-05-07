package org.example.hackathon1.domain;

import lombok.RequiredArgsConstructor;
import org.example.hackathon1.infrastructure.EmpresaRepository;
import org.example.hackathon1.infrastructure.RestriccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestriccionService {
    private final RestriccionRepository restriccionRepository;
    private final EmpresaRepository empresaRepository;

    public Restriccion createRestriccion(Long companyId, Restriccion restriccion) {
        Empresa empresa = empresaRepository.findById(companyId).orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
        restriccion.setEmpresa(empresa);
        return restriccionRepository.save(restriccion);
    }

    public List<Restriccion> getAllRestricciones(Long empresaId) {
        return restriccionRepository.findByEmpresaId(empresaId);
    }

    public Restriccion updateRestriccion(Long empresaId, Long id,  Restriccion restriccion) {
        empresaRepository.findById(empresaId).orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
        restriccion.setId(id);
        return restriccionRepository.save(restriccion);
    }

    public void deleteRestriccion(Long id) {
        restriccionRepository.deleteById(id);
    }


}
