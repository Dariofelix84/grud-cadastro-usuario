package com.felix.grud_cadastro_usuario.controller;

import com.felix.grud_cadastro_usuario.business.UsuarioService;
import com.felix.grud_cadastro_usuario.infrastructure.entitie.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Estou expondo a minha entedidade para teste (na prática tem que expor minha DTO)
    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody UsuarioEntity usuario) {
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }

//    @GetMapping("/usuario")
//    public UsuarioRecordDTO usuarioRecordDTO(@RequestParam Integer id) {
//        return usuarioService.getUsuarioRecordDTO(id);
//    }


    @GetMapping
    public ResponseEntity<UsuarioEntity> buscarUsuarioPorEmail(@RequestParam String email) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email) {
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam Integer id,
                                                      @RequestBody UsuarioEntity usuario) {
        usuarioService.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-by-email")
    public ResponseEntity<Void> atualizarUsuarioPorEmail(@RequestParam String email,
                                                      @RequestBody UsuarioEntity usuario) {
        usuarioService.atualizarUsuarioPorEmail(email, usuario);
        return ResponseEntity.ok().build();
    }
}
