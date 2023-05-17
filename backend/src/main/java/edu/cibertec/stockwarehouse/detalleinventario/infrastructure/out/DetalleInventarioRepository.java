package edu.cibertec.stockwarehouse.detalleinventario.infrastructure.out;

import edu.cibertec.stockwarehouse.detalleinventario.model.DetalleInventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleInventarioRepository extends JpaRepository<DetalleInventario, Integer> {
}
