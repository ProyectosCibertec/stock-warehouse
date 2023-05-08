package edu.cibertec.stockwarehouse.Producto.domain.dto;

import edu.cibertec.stockwarehouse.Categoria.domain.model.Categoria;
import lombok.Data;

import java.io.Serializable;
@Data
public class ProductoUpdateDTO implements Serializable {
    private int id;
    private Categoria categoria;
    private String codigobarra;

    private String descripcion;

    private String marca;

    private String stock;

    private int estado;
}
