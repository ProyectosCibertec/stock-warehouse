package edu.cibertec.stockwarehouse.Producto.infrastructure.out;
import edu.cibertec.stockwarehouse.Producto.domain.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
