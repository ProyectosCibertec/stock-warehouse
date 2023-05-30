package edu.cibertec.stockwarehouse.usuario.domain.model;

import edu.cibertec.stockwarehouse.empleado.domain.model.Empleado;
import edu.cibertec.stockwarehouse.tipousuario.domain.model.TipoUsuario;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private long id_usuario;

    @OneToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_tipo_usuario")
    private TipoUsuario tipoUsuario;

    @Column(name = "login_usuario", length = 50, nullable = false)
    private String login_usuario;

    @Column(name = "contrasena_usuario", length = 350, nullable = false)
    private String contrasena_usuario;

    @Column(name = "estado")
    private int estado;
}
