package edu.cibertec.stockwarehouse.ordencompra.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class OrdenCompraUpdateDTO {

    private int id_orden_compra;

    private String nro_orden_compra;

    @Temporal(value= TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaorden_compra;

    @Temporal(value=TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaentrega;

    private String condicionespago;

    private BigDecimal valortotal_orden;

    private int estado;

    private int proveedorId;
}
