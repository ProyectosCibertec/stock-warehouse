package edu.cibertec.stockwarehouse.ordencompra.domain.dto;

import edu.cibertec.stockwarehouse.detalleordencompra.domain.dto.DetalleOrdenCompraDTO;
import edu.cibertec.stockwarehouse.proveedor.domain.model.Proveedor;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
public class OrdenCompraDetalleDTO {

    private int id_orden_compra;

    private String nro_orden_compra;

    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaorden_compra;

    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaentrega;

    private String condicionespago;

    private BigDecimal valortotal_orden;

    private int  estado;

    private Proveedor proveedor;

    private List<DetalleOrdenCompraDTO> ordenCompraDetalleDTOList =  new ArrayList<>();
}
