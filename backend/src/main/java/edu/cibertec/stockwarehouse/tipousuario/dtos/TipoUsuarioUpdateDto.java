package edu.cibertec.stockwarehouse.tipousuario.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoUsuarioUpdateDto {
    private long idTipoUsuario;
    private String nombreTipoUsuario;
    private int estado;
}
