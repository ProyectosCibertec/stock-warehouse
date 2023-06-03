package edu.cibertec.stockwarehouse.proveedor.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProveedorCreateDTO implements Serializable {

    private String razonSocial;
    private String ruc;
    private String email;
    private String direccion;
    private String telefono;
    private int estado;

}
