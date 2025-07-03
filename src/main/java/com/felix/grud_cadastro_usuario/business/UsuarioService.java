package com.felix.grud_cadastro_usuario.business;

import com.felix.grud_cadastro_usuario.infrastructure.entitys.Usuario;
import com.felix.grud_cadastro_usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    //Injeção de dependência manual, tem mais duas maneiras

    private final UsuarioRepository repository;
    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsuario(Usuario usuario) {
        repository.saveAndFlush(usuario);
    }

    //Opção de buscar usuário por Email para teste
    public Usuario buscarUsuarioPorEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
        );
    }

    // Deletar por Email, para teste
    public void deletarUsuarioPorEmail(String email) {
        repository.deleteByEmail(email);
    }

//    public void deletarUsuariPorId(Integer id) {
//        repository.deleteById(id);
//    }

    /*Melhor maneira é com MapStruct
    Desta maneira só atualiza o que for passado, e não perde nenhum dado da coluna do BD*/
    public void atualizarUsuarioPorId(Integer id, Usuario usuario) {
        Usuario usuarioEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuário não encontrado"));
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();

        repository.saveAndFlush(usuarioAtualizado);
    }

    public void atualizarUsuarioPorEmail(String email, Usuario usuario) {
        Usuario usuarioEntity = repository.findByEmail(email).orElseThrow(() ->
                new RuntimeException("Usuário não encontrado"));

        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();

        repository.saveAndFlush(usuarioAtualizado);
    }
}
