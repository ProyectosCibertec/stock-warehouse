package edu.cibertec.stockwarehouse.categoria.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoriaCreateDTO implements Serializable {
    private String nombre;
    private int estado;
}
