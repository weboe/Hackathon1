package org.example.hackathon1.domain;
import lombok.RequiredArgsConstructor;

import org.example.hackathon1.infrastructure.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public Empresa createEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Empresa toggleEmpresaStatus(Long id, boolean status) {
        Empresa empresa = empresaRepository.findById(id).orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
        empresa.setEstadoActivo(status);
        return empresaRepository.save(empresa);
    }

    public List<Empresa> getAllEmpresas() {
        return empresaRepository.findAll();
    }


    public Empresa updateEmpresa(Long id, Empresa empresa) {
        Empresa existingEmpresa = empresaRepository.findById(id).orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
        existingEmpresa.setNombre(empresa.getNombre());
        existingEmpresa.setRuc(empresa.getRuc());
        return empresaRepository.save(existingEmpresa);
    }

    public void updateEmpresaStatus(Long id, Boolean estadoActivo) {
        Empresa empresa = empresaRepository.findById(id).orElseThrow(() -> new RuntimeException("Empresa not found"));
        empresa.setEstadoActivo(estadoActivo);
        empresaRepository.save(empresa);
    }

    public List<Empresa> getEmpresasByEstadoActivo(Boolean estadoActivo) {
        return empresaRepository.findAll().stream()
                .filter(empresa -> empresa.getEstadoActivo().equals(estadoActivo))
                .toList();
    }

    public String getEmpresaConsumption(Long id) {
        return "Reporte de consumo de la empresa con ID: " + id;
    }


    public Optional<Empresa> getEmpresaById(Long id) {
        return empresaRepository.findById(id);
    }
}
