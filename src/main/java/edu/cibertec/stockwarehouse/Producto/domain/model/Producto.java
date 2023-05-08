package edu.cibertec.stockwarehouse.Producto.domain.model;

import edu.cibertec.stockwarehouse.Categoria.domain.model.Categoria;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="tb_producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_producto")
    private int id;


    @ManyToOne
    @JoinColumn(name = "id_categoria" , nullable = false)
    private Categoria categoria;

    @Column(name = "codigobar_producto" , length = 14, nullable = false)
    private String codigobarra;

    @Column(name = "descripcion_producto" , length = 250, nullable = false)
    private String descripcion;

    @Column(name = "marca_producto" , length = 50, nullable = false)
    private String marca;

    @Column(name = "stock_producto")
    private int stock;

    @Column(name = "estado")
    private int estado;

}
