package edu.cibertec.stockwarehouse.cabecerainventario.domain.dto;

import edu.cibertec.stockwarehouse.detalleinventario.domain.dto.DetalleInventarioDTO;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CabeceraInventarioDetalleDTO {

    private int id_cab_inventario;
    private int tipo_inventario;
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_cab_inventario;
    private int estado;
    private String nomempleado;

    private List<DetalleInventarioDTO> listaDetalleInventarioDTO = new ArrayList<>();
}
