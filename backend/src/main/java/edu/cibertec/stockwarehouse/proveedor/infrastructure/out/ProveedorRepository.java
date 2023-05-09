package edu.cibertec.stockwarehouse.proveedor.infrastructure.out;

import edu.cibertec.stockwarehouse.proveedor.domain.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}
