package com.felix.grud_cadastro_usuario.business.mapstruct;

import com.felix.grud_cadastro_usuario.infrastructure.entitie.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    UsuarioEntity paraUsuario(UsuarioResquestDTO dto);

    UsuarioResponseDTO paraResponseDTO(UsuarioEntity entity);

    List<UsuarioResponseDTO> paraListUsuarioResponseDTO(List<UsuarioEntity> lista);
}
