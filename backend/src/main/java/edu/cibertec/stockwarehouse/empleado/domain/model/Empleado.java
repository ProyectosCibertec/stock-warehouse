package edu.cibertec.stockwarehouse.empleado.domain.model;

import edu.cibertec.stockwarehouse.cargo.domain.model.Cargo;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private int id;

    @Column(name = "nombre_empleado", length = 60, nullable = false)
    private String nombre;

    @Column(name = "apellido_empleado", length = 90, nullable = false)
    private String apellido;

    @Column(name = "correo_empleado", length = 70, nullable = false)
    private String correo;

    @Column(name = "telefono_empleado", length = 15, nullable = false)
    private String telefono;

    @Column(name = "fechaIngreso", nullable = false)
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaIngreso;

    @Column(name = "fechaCese")
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaCese;

    @ManyToOne
    @JoinColumn(name = "id_cargo", nullable = true)
    private Cargo cargo;

    @Column(name = "estado")
    private int estado;
}
