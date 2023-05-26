package edu.cibertec.stockwarehouse.tipousuario.infrastructure.out;

import edu.cibertec.stockwarehouse.tipousuario.domain.model.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {
}
