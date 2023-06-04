package edu.cibertec.stockwarehouse.ordencompra.domain.model;

import edu.cibertec.stockwarehouse.proveedor.domain.model.Proveedor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "tb_Ordencompra")
public class OrdenCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden_compra")
    private int id_orden_compra;

    @Column(name = "nro_orden_compra", length = 10, nullable = false)
    private String nro_orden_compra;

    @Column(name = "fechaorden_compra", nullable = false)
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaorden_compra;

    @Column(name = "fechaentrega", nullable = false)
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaentrega;

    @Column(name = "condicionespago", length = 25, nullable = false)
    private String condicionespago;

    @Column(name = "valortotal_orden", scale = 2, nullable = false)
    private BigDecimal valortotal_orden;

    @Column(name = "estado")
    private int estado;

    //relacionar ordencompra y proveedor
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;
}
