package org.example.hackathon1.application;

import lombok.RequiredArgsConstructor;
import org.example.hackathon1.domain.Empresa;
import org.example.hackathon1.domain.EmpresaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/companies")
@RequiredArgsConstructor
public class EmpresaController {
    private final EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> createEmpresa(@RequestBody Empresa empresa) {
        Empresa createdEmpresa = empresaService.createEmpresa(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmpresa);
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> getAllEmpresas() {
        List<Empresa> empresas = empresaService.getAllEmpresas();
        return ResponseEntity.ok(empresas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable Long id) {
        Empresa empresa = empresaService.getEmpresaById(id).orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
        return ResponseEntity.ok(empresa); // 200 OK
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> updateEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        Empresa updatedEmpresa = empresaService.updateEmpresa(id, empresa);
        return ResponseEntity.ok(updatedEmpresa); // 200 OK
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Empresa> toggleEmpresaStatus(@PathVariable Long id, @RequestParam boolean status) {
        Empresa updatedEmpresa = empresaService.toggleEmpresaStatus(id, status);
        return ResponseEntity.ok(updatedEmpresa); // 200 OK
    }

    @GetMapping("/{id}/consumption")
    public ResponseEntity<String> getEmpresaConsumption(@PathVariable Long id) {
        String consumptionReport = empresaService.getEmpresaConsumption(id);
        return ResponseEntity.ok(consumptionReport); // 200 OK
    }


}
