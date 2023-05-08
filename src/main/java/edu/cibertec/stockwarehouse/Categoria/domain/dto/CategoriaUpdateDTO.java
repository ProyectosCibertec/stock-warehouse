package edu.cibertec.stockwarehouse.Categoria.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoriaUpdateDTO implements Serializable {
    private int id;
    private String nombre;
    private int estado;
}
