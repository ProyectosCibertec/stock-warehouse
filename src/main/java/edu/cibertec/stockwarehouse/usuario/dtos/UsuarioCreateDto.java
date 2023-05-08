package edu.cibertec.stockwarehouse.usuario.dtos;


import edu.cibertec.stockwarehouse.tipousuario.dtos.TipoUsuarioDto;
import edu.cibertec.stockwarehouse.tipousuario.model.TipoUsuario;
import edu.cibertec.stockwarehouse.usuario.model.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Set;


@Getter
@Setter
public class UsuarioCreateDto {
    private String login_usuario;
    private long idTipoUsuario;
    private String contrasena_usuario;
    private int estado;

}
