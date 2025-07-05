package com.felix.grud_cadastro_usuario.infrastructure.repository;

import com.felix.grud_cadastro_usuario.infrastructure.entitie.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    Optional<UsuarioEntity> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
