package org.example.hackathon1.infrastructure;

import org.example.hackathon1.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmpresaId(Long empresaId);
    List<User> findByIdAndEmpresaId(Long userId, Long empresaId);
    User findFirstByIdAndEmpresaId(Long userId, Long empresaId);

}

