package edu.cibertec.stockwarehouse.detalleordencompra.domain.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetalleOrdenCompraUpdateDTO {
    private int id_detalle_orden;
    private int cantidad;

    private BigDecimal precio_unitario;

    private BigDecimal costo_detalleorden;

    private int estado;

    private int ordencompraid;

    private int productoid;
}
