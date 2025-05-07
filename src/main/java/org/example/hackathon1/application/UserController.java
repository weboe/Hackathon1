package org.example.hackathon1.application;

import lombok.RequiredArgsConstructor;
import org.example.hackathon1.domain.LimiteUsuario;
import org.example.hackathon1.domain.User;
import org.example.hackathon1.domain.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestParam Long companyId, @RequestBody User user) {
        User createdUser = userService.createUser(companyId, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(@RequestParam Long companyId) {
        List<User> users = userService.getAllUsers(companyId);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id, @RequestParam Long companyId) {
        User user = userService.getUserById(companyId, id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestParam Long companyId, @RequestBody User user) {
        User updatedUser = userService.updateUser(companyId, id, user);
        return ResponseEntity.ok(updatedUser);
    }

    @PostMapping("/{id}/limits")
    public ResponseEntity<LimiteUsuario> assignLimit(@PathVariable Long id, @RequestBody LimiteUsuario limiteUsuario) {
        LimiteUsuario createdLimit = userService.assignLimitToUser(id, limiteUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLimit);
    }
}
