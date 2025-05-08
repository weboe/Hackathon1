package org.example.hackathon1.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entityName, Long id) {
        super(entityName + " with ID " + id + " not found.");
    }
}
