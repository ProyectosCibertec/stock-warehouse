package edu.cibertec.stockwarehouse.producto.infrastructure.out;

import edu.cibertec.stockwarehouse.producto.domain.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
