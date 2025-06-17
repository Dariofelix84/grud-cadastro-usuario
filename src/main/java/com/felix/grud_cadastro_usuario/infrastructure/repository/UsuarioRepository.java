package com.felix.grud_cadastro_usuario.infrastructure.repository;

import com.felix.grud_cadastro_usuario.infrastructure.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);
}
