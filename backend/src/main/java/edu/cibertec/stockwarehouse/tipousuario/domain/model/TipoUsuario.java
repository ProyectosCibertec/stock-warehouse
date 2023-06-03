package edu.cibertec.stockwarehouse.tipousuario.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_tipo_usuario")
@Getter
@Setter
public class TipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_usuario")
    private long idTipoUsuario;

    @Column(name = "nombre_tipo_usuario", length = 50, nullable = false)
    private String nombreTipoUsuario;

    @Column(name = "estado")
    private int estado;

    public String NombreEstado() {
        String nombreEstado = null;
        switch (estado) {
            case 0:
                nombreEstado = "Activo";
                break;
            case 1:
                nombreEstado = "Anulado";
                break;
            default:
                nombreEstado = "";
        }
        return nombreEstado;
    }
}
