package edu.cibertec.stockwarehouse.usuario.dtos;


import edu.cibertec.stockwarehouse.tipousuario.dtos.TipoUsuarioDto;
import edu.cibertec.stockwarehouse.tipousuario.model.TipoUsuario;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UsuarioDto {
    private long id_usuario;
    private String nombreTipoUsuario;
    private String login_usuario;
    private String contrasena_usuario;
    private int estado;
}
