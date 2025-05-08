package org.example.hackathon1.exceptions;

public class UserNotFoundException extends EntityNotFoundException {
    public UserNotFoundException(Long id) {
        super("User", id);
    }
}
