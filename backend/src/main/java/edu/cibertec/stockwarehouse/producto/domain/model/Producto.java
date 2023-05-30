package edu.cibertec.stockwarehouse.producto.domain.model;

import edu.cibertec.stockwarehouse.categoria.domain.model.Categoria;
import edu.cibertec.stockwarehouse.detalleordencompra.domain.model.DetalleOrdenCompra;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "tb_producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @Column(name = "codigobar_producto", length = 14, nullable = false)
    private String codigobarra;

    @Column(name = "descripcion_producto", length = 250, nullable = false)
    private String descripcion;

    @Column(name = "marca_producto", length = 50, nullable = false)
    private String marca;

    @Column(name = "stock_producto")
    private int stock;

    @Column(name = "estado")
    private int estado;
}
