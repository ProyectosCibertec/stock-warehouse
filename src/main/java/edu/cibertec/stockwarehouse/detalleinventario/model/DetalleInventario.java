package edu.cibertec.stockwarehouse.detalleinventario.model;

import edu.cibertec.stockwarehouse.cabecerainventario.domain.model.CabeceraInventario;
import edu.cibertec.stockwarehouse.ordencompra.domain.model.OrdenCompra;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_cabecerainventario")
public class DetalleInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalleInventario")
    private int id_detalleInventario;



    @Column(name = "nro_orden_compra")
    private char nro_orden_compra;

    @Column(name = "id_producto")
    private char producto;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "observaciones")
    private int observaciones;


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
