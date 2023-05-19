package edu.cibertec.stockwarehouse.detalleinventario.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetalleInventarioUpdateDTO {

    private int id_detalleInventario;
    private int id_cab_inventario;
    private String nro_orden_compra;
    private int id_producto;
    private int cantidad;
    private String observaciones;
    private int estado;
}
