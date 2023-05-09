package edu.cibertec.stockwarehouse.usuario.mappers;

import edu.cibertec.stockwarehouse.usuario.dtos.UsuarioCreateDto;
import edu.cibertec.stockwarehouse.usuario.dtos.UsuarioDto;
import edu.cibertec.stockwarehouse.usuario.dtos.UsuarioUpdateDto;
import edu.cibertec.stockwarehouse.usuario.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
    @Mapping(target = "nombreTipoUsuario", source = "tipoUsuario.nombreTipoUsuario")
    UsuarioDto usuarioAUsuarioDto(Usuario usuario);
    Usuario usuarioDtoAUsuario(UsuarioDto usuarioDto);
    @Mapping(target = "tipoUsuario.idTipoUsuario", source = "usuarioCreateDto.idTipoUsuario")
    Usuario usaurioCreateDtoAUsuario (UsuarioCreateDto usuarioCreateDto);

    @Mapping(target = "tipoUsuario.idTipoUsuario", source = "usuarioUpdateDto.idTipoUsuario")
    Usuario usaurioUpdateDtoAUsuario (UsuarioUpdateDto usuarioUpdateDto);
    @Mapping(target = "nombreTipoUsuario", source = "tipoUsuario.nombreTipoUsuario")
    List<UsuarioDto> listaUsuarioAListaUsuarioDto (List<Usuario> listaUsuario);
}
