package edu.cibertec.stockwarehouse.tipousuario.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoUsuarioDto {

    private long idTipoUsuario;
    private String nombreTipoUsuario;
    private int estado;
}
