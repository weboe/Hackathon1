package org.example.hackathon1.exceptions;

public class EmpresaNotFoundException extends EntityNotFoundException {
    public EmpresaNotFoundException(Long id) {
        super("Empresa", id);
    }
}
