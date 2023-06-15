package edu.cibertec.stockwarehouse.cabecerainventario.domain.dto;

import edu.cibertec.stockwarehouse.empleado.domain.model.Empleado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CabeceraInventarioCreateDTO {

    private int tipo_inventario;

    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_cab_inventario;

    private int estado;

    private Empleado empleado;

}
