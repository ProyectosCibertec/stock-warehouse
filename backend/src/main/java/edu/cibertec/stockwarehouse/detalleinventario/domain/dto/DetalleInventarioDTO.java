package edu.cibertec.stockwarehouse.detalleinventario.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleInventarioDTO {
    private int id_detalleInventario;
    private int id_cab_inventario;
    //private String nro_orden_compra;
    private int id_producto;
    private int cantidad;
    private String observaciones;
    private int estado;
}
