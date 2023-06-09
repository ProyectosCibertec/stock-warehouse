package edu.cibertec.stockwarehouse.detalleinventario.domain.model;

import edu.cibertec.stockwarehouse.producto.domain.model.Producto;
import edu.cibertec.stockwarehouse.cabecerainventario.domain.model.CabeceraInventario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_detalleinventario")
public class DetalleInventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalleInventario")
    private int id_detalleInventario;

    @Column(name = "nro_orden_compra")
    private String nro_orden_compra;

    @ManyToOne()
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "estado")
    private int estado;

    //relacion detalleinventario y  cabecerainventario
    @ManyToOne()
    @JoinColumn(name = "id_cab_inventario")
    private CabeceraInventario cabecerainventario;

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
