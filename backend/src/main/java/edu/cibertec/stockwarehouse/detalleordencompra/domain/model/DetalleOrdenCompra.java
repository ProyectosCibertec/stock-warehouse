package edu.cibertec.stockwarehouse.detalleordencompra.domain.model;

import edu.cibertec.stockwarehouse.ordencompra.domain.model.OrdenCompra;
import edu.cibertec.stockwarehouse.producto.domain.model.Producto;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "tb_detalleordencompra")
public class DetalleOrdenCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_orden")
    private int id_detalle_orden;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_unitario", scale = 2, nullable = false)
    private BigDecimal precio_unitario;

    @Column(name = "costo_detalleorden", scale = 2, nullable = false)
    private BigDecimal costo_detalleorden;

    @Column(name = "estado")
    private int estado;

    //relacion detalleordencompra y  producto
    @ManyToOne
    @JoinColumn(name = "id_orden_compra")
    private OrdenCompra ordencompra;

    //relacion detalleordencompra y  ordenCompra
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;


}
