package edu.cibertec.stockwarehouse.detalleordencompra.infrastructure.out;

import edu.cibertec.stockwarehouse.detalleordencompra.domain.model.DetalleOrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleOrdenCompraRepositoy extends JpaRepository<DetalleOrdenCompra, Integer> {
}
