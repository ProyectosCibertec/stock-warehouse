package edu.cibertec.stockwarehouse.usuario.infrastructure.out;

import edu.cibertec.stockwarehouse.usuario.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(value = "SELECT u FROM Usuario u WHERE u.login_usuario = :username")
    Usuario findByLoginUsuario(@Param("username") String login_usuario);
}
