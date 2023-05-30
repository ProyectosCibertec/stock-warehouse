package edu.cibertec.stockwarehouse.usuario.domain.dto;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UsuarioDto {
    private long id_usuario;
    private String nombreTipoUsuario;
    private String nombreCompletoEmpleado;
    private String login_usuario;
    private String contrasena_usuario;
    private int estado;
}
