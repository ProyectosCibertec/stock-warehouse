package edu.cibertec.stockwarehouse.usuario.service;

import edu.cibertec.stockwarehouse.usuario.dtos.UsuarioCreateDto;
import edu.cibertec.stockwarehouse.usuario.dtos.UsuarioDto;
import edu.cibertec.stockwarehouse.usuario.dtos.UsuarioUpdateDto;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDto> listarUsuarios();

    UsuarioDto obtenerUsuarioPorId(long id);

    UsuarioDto registrarProducto(UsuarioCreateDto usuarioCreateDto);

    UsuarioDto actualizarProducto(UsuarioUpdateDto usuarioUpdateDto);

    String eliminarUsuario(long id);

}
