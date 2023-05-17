package edu.cibertec.stockwarehouse.tipousuario.service;

import edu.cibertec.stockwarehouse.tipousuario.dtos.TipoUsuarioCreateDto;
import edu.cibertec.stockwarehouse.tipousuario.dtos.TipoUsuarioDto;
import edu.cibertec.stockwarehouse.tipousuario.dtos.TipoUsuarioUpdateDto;

import java.util.List;

public interface TipoUsuarioService {

    List<TipoUsuarioDto> listarTipoUsuarios();

    TipoUsuarioDto obtenerTipoUsuarioPorId(long id);

    TipoUsuarioDto registrarTipoUsuario(TipoUsuarioCreateDto tipoUsuarioCreateDto);

    TipoUsuarioDto actualizarTipoUsuario(TipoUsuarioUpdateDto tipoUsuarioUpdateDto);

    String eliminarTipoUsuario(long id);

}
