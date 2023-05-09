package edu.cibertec.stockwarehouse.proveedor.domain.dto;

import edu.cibertec.stockwarehouse.ordencompra.domain.model.OrdenCompra;
import lombok.Data;
import java.io.Serializable;
import java.util.Set;

@Data
public class ProveedorUpdateDTO implements Serializable {
    private Long id;
    private String razonSocial;
    private String ruc;
    private String email;
    private String direccion;
    private String telefono;
    private int estado;
    private Set<OrdenCompra> ordenes;
}
