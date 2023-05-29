package edu.cibertec.stockwarehouse.empleado.domain.dto;

import edu.cibertec.stockwarehouse.cargo.domain.dto.CargoDTO;
import edu.cibertec.stockwarehouse.cargo.domain.model.Cargo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EmpleadoDTO implements Serializable {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private Date fechaIngreso;
    private Date fechaCese;
    private CargoDTO cargo;
    private int estado;
}
