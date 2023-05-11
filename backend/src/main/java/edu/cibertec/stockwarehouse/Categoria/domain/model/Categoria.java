package edu.cibertec.stockwarehouse.Categoria.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private int id;

    @Column(name = "nombre_categoria", length = 60, nullable = false)
    private String nombre;

    @Column(name = "estado")
    private int estado;
}


