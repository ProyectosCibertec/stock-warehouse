package edu.cibertec.stockwarehouse.usuario.domain.mapper;

import edu.cibertec.stockwarehouse.usuario.domain.dto.UsuarioCreateDto;
import edu.cibertec.stockwarehouse.usuario.domain.dto.UsuarioDto;
import edu.cibertec.stockwarehouse.usuario.domain.dto.UsuarioUpdateDto;
import edu.cibertec.stockwarehouse.usuario.domain.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(target = "nombreCompletoEmpleado", expression = "java(usuario.getEmpleado().getNombre() + \" \" + usuario.getEmpleado().getApellido())")
    @Mapping(target = "nombreTipoUsuario", expression = "java(usuario.getTipoUsuario().getNombreTipoUsuario())")
    UsuarioDto usuarioAUsuarioDto(Usuario usuario);

    Usuario usuarioDtoAUsuario(UsuarioDto usuarioDto);

    @Mapping(target = "empleado.id", source = "usuarioCreateDto.idEmpleado")
    @Mapping(target = "tipoUsuario.idTipoUsuario", source = "usuarioCreateDto.idTipoUsuario")
    Usuario usaurioCreateDtoAUsuario(UsuarioCreateDto usuarioCreateDto);

    @Mapping(target = "empleado.id", source = "usuarioUpdateDto.idEmpleado")
    @Mapping(target = "tipoUsuario.idTipoUsuario", source = "usuarioUpdateDto.idTipoUsuario")
    Usuario usaurioUpdateDtoAUsuario(UsuarioUpdateDto usuarioUpdateDto);

    @Mapping(target = "nombreCompletoEmpleado", expression = "java(usuario.getEmpleado().getNombre() + \" \" + usuario.getEmpleado().getApellido())")
    @Mapping(target = "nombreTipoUsuario", expression = "java(usuario.getTipoUsuario().getNombreTipoUsuario())")
    List<UsuarioDto> listaUsuarioAListaUsuarioDto(List<Usuario> listaUsuario);

}
