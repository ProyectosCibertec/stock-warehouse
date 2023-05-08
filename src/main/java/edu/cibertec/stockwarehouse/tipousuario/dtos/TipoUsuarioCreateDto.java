package edu.cibertec.stockwarehouse.tipousuario.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoUsuarioCreateDto {
    private String nombreTipoUsuario;
    private int estado;
}
