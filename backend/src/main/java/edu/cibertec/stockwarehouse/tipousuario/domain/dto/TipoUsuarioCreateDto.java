package edu.cibertec.stockwarehouse.tipousuario.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoUsuarioCreateDto {
    private String nombreTipoUsuario;
    private int estado;
}
