package com.felix.grud_cadastro_usuario.business;

import com.felix.grud_cadastro_usuario.infrastructure.entitie.UsuarioEntity;
import com.felix.grud_cadastro_usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    //Injeção de dependência manual, tem mais duas maneiras


    private final UsuarioRepository usuarioRepository;


//    public UsuarioRecordDTO getUsuarioRecordDTO(Integer id) {
//        Usuario usuario = this.usuarioRepository.findById(id).orElseThrow(() ->
//                new RuntimeException("Id não encontrado"));
//        return usuarioMapper.usuarioParaUsuarioRecordDTO(usuario);
//    }


    public void salvarUsuario(UsuarioEntity usuario) {
        usuarioRepository.saveAndFlush(usuario);
    }

    //Opção de buscar usuário por Email para teste
    public UsuarioEntity buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
        );
    }

    // Deletar por Email, para teste
    public void deletarUsuarioPorEmail(String email) {
        usuarioRepository.deleteByEmail(email);
    }

//    public void deletarUsuariPorId(Integer id) {
//        repository.deleteById(id);
//    }

    /*Melhor maneira é com MapStruct
    Desta maneira só atualiza o que for passado, e não perde nenhum dado da coluna do BD*/
    public void atualizarUsuarioPorId(Integer id, UsuarioEntity usuario) {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuário não encontrado"));
        UsuarioEntity usuarioAtualizado = UsuarioEntity.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();

        usuarioRepository.saveAndFlush(usuarioAtualizado);
    }

    public void atualizarUsuarioPorEmail(String email, UsuarioEntity usuario) {
        UsuarioEntity usuarioEntity = usuarioRepository.findByEmail(email).orElseThrow(() ->
                new RuntimeException("Usuário não encontrado"));

        UsuarioEntity usuarioAtualizado = UsuarioEntity.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();

        usuarioRepository.saveAndFlush(usuarioAtualizado);
    }
}
