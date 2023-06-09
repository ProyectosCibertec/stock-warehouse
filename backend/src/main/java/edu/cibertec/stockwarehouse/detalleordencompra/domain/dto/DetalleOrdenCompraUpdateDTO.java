package edu.cibertec.stockwarehouse.detalleordencompra.domain.dto;

import edu.cibertec.stockwarehouse.ordencompra.domain.model.OrdenCompra;
import edu.cibertec.stockwarehouse.producto.domain.model.Producto;
import lombok.*;

import java.math.BigDecimal;


@Data
public class DetalleOrdenCompraUpdateDTO {

    private int id_detalle_orden;
    private int cantidad;

    private BigDecimal precio_unitario;

    private BigDecimal costo_detalleorden;

    private int estado;

    private OrdenCompra ordencompra;

    private Producto producto;
}
