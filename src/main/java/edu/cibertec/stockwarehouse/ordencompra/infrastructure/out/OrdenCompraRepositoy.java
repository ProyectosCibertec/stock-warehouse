package edu.cibertec.stockwarehouse.ordencompra.infrastructure.out;

import edu.cibertec.stockwarehouse.ordencompra.domain.model.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenCompraRepositoy extends JpaRepository<OrdenCompra,Integer> {
}
