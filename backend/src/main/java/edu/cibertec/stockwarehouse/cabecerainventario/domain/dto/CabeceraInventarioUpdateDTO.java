package edu.cibertec.stockwarehouse.cabecerainventario.domain.dto;

import edu.cibertec.stockwarehouse.empleado.domain.model.Empleado;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
public class CabeceraInventarioUpdateDTO {

    private int id_cab_inventario;
    private int tipo_inventario;
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_cab_inventario;
    private Empleado empleado;
    private int estado;
}
