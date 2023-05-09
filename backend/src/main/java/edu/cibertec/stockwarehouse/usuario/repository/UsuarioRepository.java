package edu.cibertec.stockwarehouse.usuario.repository;

import edu.cibertec.stockwarehouse.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
