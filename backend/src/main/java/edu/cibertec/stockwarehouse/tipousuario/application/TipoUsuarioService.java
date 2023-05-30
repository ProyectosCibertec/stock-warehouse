package edu.cibertec.stockwarehouse.tipousuario.application;

import edu.cibertec.stockwarehouse.tipousuario.domain.dto.TipoUsuarioCreateDto;
import edu.cibertec.stockwarehouse.tipousuario.domain.dto.TipoUsuarioDto;
import edu.cibertec.stockwarehouse.tipousuario.domain.dto.TipoUsuarioUpdateDto;

import java.util.List;

public interface TipoUsuarioService {

    List<TipoUsuarioDto> listarTipoUsuarios();

    TipoUsuarioDto obtenerTipoUsuarioPorId(long id);

    TipoUsuarioDto registrarTipoUsuario(TipoUsuarioCreateDto tipoUsuarioCreateDto);

    TipoUsuarioDto actualizarTipoUsuario(TipoUsuarioUpdateDto tipoUsuarioUpdateDto);

    String eliminarTipoUsuario(long id);

}
