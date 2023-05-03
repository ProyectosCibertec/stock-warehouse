package edu.cibertec.stockwarehouse.cargo.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_cargo")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo")
    private int id;

    @Column(name = "nombre_cargo", length = 60, nullable = false)
    private String nombre;

    @Column(name = "estado")
    private int estado;
}
