package edu.cibertec.stockwarehouse.tipousuario.repository;

import edu.cibertec.stockwarehouse.tipousuario.model.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {
}
