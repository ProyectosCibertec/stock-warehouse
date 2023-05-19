package edu.cibertec.stockwarehouse.detalleinventario.infrastructure.out;

import edu.cibertec.stockwarehouse.detalleinventario.domain.model.DetalleInventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleInventarioRepository extends JpaRepository<DetalleInventario,Integer> {
}
