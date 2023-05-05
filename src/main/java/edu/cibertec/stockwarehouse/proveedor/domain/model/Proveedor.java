package edu.cibertec.stockwarehouse.proveedor.domain.model;

import edu.cibertec.stockwarehouse.ordencompra.domain.model.OrdenCompra;
import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "tb_proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long id;

    @Column(name = "razon_social_proveedor", length = 50, nullable = false)
    private String razonSocial;

    @Column(name = "numero_ruc_proveedor", length = 15, nullable = false)
    private String ruc;

    @Column(name = "email_proveedor", length = 50, nullable = false)
    private String email;

    @Column(name = "direccion_proveedor", length = 100, nullable = false)
    private String direccion;

    @Column(name = "telefono_proveedor", length = 15,nullable = false)
    private String telefono;

    @Column(name = "estado")
    private int estado;

    @OneToMany(mappedBy = "proveedor")
    private Set<OrdenCompra> ordenes;

    public String NombreEstado() {
        String nombreEstado = null;
        switch (estado) {
            case 0: nombreEstado = "Activo";break;
            case 1: nombreEstado = "Baja de Oficio";break;
            default: nombreEstado = "Baja Definitiva";
        }
        return nombreEstado;
    }
}
