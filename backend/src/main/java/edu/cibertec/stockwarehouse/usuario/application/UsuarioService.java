package edu.cibertec.stockwarehouse.usuario.application;

import edu.cibertec.stockwarehouse.usuario.domain.dto.UsuarioCreateDto;
import edu.cibertec.stockwarehouse.usuario.domain.dto.UsuarioDto;
import edu.cibertec.stockwarehouse.usuario.domain.dto.UsuarioUpdateDto;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDto> listarUsuarios();

    UsuarioDto obtenerUsuarioPorId(long id);

    UsuarioDto registrarProducto(UsuarioCreateDto usuarioCreateDto);

    UsuarioDto actualizarProducto(UsuarioUpdateDto usuarioUpdateDto);

    String eliminarUsuario(long id);

}
