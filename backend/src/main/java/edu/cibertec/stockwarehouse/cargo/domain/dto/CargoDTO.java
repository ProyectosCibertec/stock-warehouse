package edu.cibertec.stockwarehouse.cargo.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CargoDTO implements Serializable {
    private int id;
    private String nombre;
    private int estado;
}
