package org.example.hackathon1.application;

import lombok.RequiredArgsConstructor;
import org.example.hackathon1.domain.Restriccion;
import org.example.hackathon1.domain.RestriccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company/restrictions")
@RequiredArgsConstructor
public class RestriccionController {
    private final RestriccionService restriccionService;

    @PostMapping
    public ResponseEntity<Restriccion> createRestriccion(@RequestParam Long companyId, @RequestBody Restriccion restriccion) {
        Restriccion createdRestriccion = restriccionService.createRestriccion(companyId, restriccion);
        return ResponseEntity.status(201).body(createdRestriccion); // 201 Created
    }

    @GetMapping
    public ResponseEntity<List<Restriccion>> getAllRestricciones(@RequestParam Long empresaId) {
        List<Restriccion> restricciones = restriccionService.getAllRestricciones(empresaId);
        return ResponseEntity.ok(restricciones); // 200 OK
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restriccion> updateRestriccion(@PathVariable Long id, @RequestParam Long empresaId ,@RequestBody Restriccion restriccion) {
        Restriccion updatedRestriccion = restriccionService.updateRestriccion(empresaId, id, restriccion);
        return ResponseEntity.ok(updatedRestriccion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestriccion(@PathVariable Long id) {
        restriccionService.deleteRestriccion(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
