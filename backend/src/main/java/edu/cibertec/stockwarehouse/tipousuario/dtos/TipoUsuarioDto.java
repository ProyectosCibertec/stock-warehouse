package edu.cibertec.stockwarehouse.tipousuario.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class TipoUsuarioDto{

    private long idTipoUsuario;
    private String nombreTipoUsuario;
    private int estado;
}
