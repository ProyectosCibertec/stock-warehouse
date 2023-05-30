package edu.cibertec.stockwarehouse.usuario.infrastructure.out;

import edu.cibertec.stockwarehouse.usuario.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
