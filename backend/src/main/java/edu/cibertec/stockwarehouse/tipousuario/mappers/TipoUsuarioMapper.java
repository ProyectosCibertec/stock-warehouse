package edu.cibertec.stockwarehouse.tipousuario.mappers;

import edu.cibertec.stockwarehouse.tipousuario.dtos.TipoUsuarioCreateDto;
import edu.cibertec.stockwarehouse.tipousuario.dtos.TipoUsuarioDto;
import edu.cibertec.stockwarehouse.tipousuario.dtos.TipoUsuarioUpdateDto;
import edu.cibertec.stockwarehouse.tipousuario.model.TipoUsuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TipoUsuarioMapper {

    TipoUsuarioMapper INSTANCE = Mappers.getMapper(TipoUsuarioMapper.class);

    TipoUsuarioDto tipoUsuarioATipoUsuarioDto(TipoUsuario tipoUsuario);

    TipoUsuario tipoUsuarioDtoATipoUsuario(TipoUsuarioDto tipoUsuarioDto);

    TipoUsuario tipoUsuarioCreateDtoATipoUsuario(TipoUsuarioCreateDto tipoUsuarioCreateDto);

    TipoUsuario tipoUsuarioUpdateDtoATipoUsuario(TipoUsuarioUpdateDto tipoUsuarioUpdateDto);

    List<TipoUsuarioDto> listaTipoUsuarioAListaTipoUsuarioDto(List<TipoUsuario> listaTipoUsuario);

}
