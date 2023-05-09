package edu.cibertec.stockwarehouse.cargo.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CargoCreateDTO implements Serializable {
    private String nombre;
    private int estado;
}
