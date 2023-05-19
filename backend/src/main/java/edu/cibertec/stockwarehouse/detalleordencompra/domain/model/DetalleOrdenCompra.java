package edu.cibertec.stockwarehouse.detalleordencompra.domain.model;

import edu.cibertec.stockwarehouse.Producto.domain.model.Producto;
import edu.cibertec.stockwarehouse.ordencompra.domain.model.OrdenCompra;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden_compra")
    private OrdenCompra ordencompra;


    //relacion detalleordencompra y  ordenCompra
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private Producto producto;


    //método para cálcular el costo del tetalle
    public BigDecimal calcularCostoDetalleOrden(BigDecimal precio_unitario, BigDecimal costo_detalleorden) {
        BigDecimal costo = precio_unitario.multiply(costo_detalleorden);
        return costo;
    }

    //método para asignar nombre a los estados
    public String NombreEstado() {
        String nombreEstado = null;
        switch (estado) {
            case 0:
                nombreEstado = "Activo";
                break;
            case 1:
                nombreEstado = "Anulado";
                break;
            default:
                nombreEstado = "";
        }
        return nombreEstado;
    }
}
