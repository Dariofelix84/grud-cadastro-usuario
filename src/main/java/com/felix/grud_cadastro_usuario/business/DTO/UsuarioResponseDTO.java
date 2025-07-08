package com.felix.grud_cadastro_usuario.business.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponseDTO {

    @JsonProperty(required = true)
    private String email;
    @JsonProperty(required = true)
    private String nome;

}
