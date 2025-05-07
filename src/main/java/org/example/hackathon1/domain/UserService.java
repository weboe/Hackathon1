package org.example.hackathon1.domain;
import lombok.RequiredArgsConstructor;
import org.example.hackathon1.infrastructure.EmpresaRepository;
import org.example.hackathon1.infrastructure.LimiteUsuarioRepository;
import org.example.hackathon1.infrastructure.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EmpresaRepository empresaRepository;
    private final LimiteUsuarioRepository limiteUsuarioRepository;

    public User createUser(Long empresaId, User user) {
        Empresa empresa = empresaRepository.findById(empresaId).orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
        user.setEmpresa(empresa);
        return userRepository.save(user);
    }

    public List<User> getAllUsers(Long empresaId) {
        return userRepository.findByEmpresaId(empresaId);
    }

    public User getUserById(Long companyId, Long userId) {
        // Buscar usuario por ID y empresa
        User user = userRepository.findFirstByIdAndEmpresaId(userId, companyId);
        if (user == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        return user;  // Devuelve el usuario si se encuentra
    }

    public User updateUser(Long companyId, Long userId, User user) {
        User existingUser = userRepository.findFirstByIdAndEmpresaId(userId, companyId);
        if (existingUser == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        existingUser.setNombre(user.getNombre());
        existingUser.setEmail(user.getEmail());

        Empresa empresa = empresaRepository.findById(companyId).orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
        existingUser.setEmpresa(empresa);

        return userRepository.save(existingUser);
    }

    public LimiteUsuario assignLimitToUser(Long userId, LimiteUsuario limiteUsuario) {
        limiteUsuario.setUserId(userId);  // Asignar límite al usuario
        return limiteUsuarioRepository.save(limiteUsuario);
    }

    public String getUserConsumption(Long userId) {
        return "Reporte de consumo del usuario con ID: " + userId;
    }

}
