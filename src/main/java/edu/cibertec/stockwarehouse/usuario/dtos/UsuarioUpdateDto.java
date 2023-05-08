package edu.cibertec.stockwarehouse.usuario.dtos;


import edu.cibertec.stockwarehouse.tipousuario.dtos.TipoUsuarioDto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UsuarioUpdateDto {

    private long id_usuario;
    private long idTipoUsuario;
    private String login_usuario;
    private String contrasena_usuario;
    private int estado;
}
