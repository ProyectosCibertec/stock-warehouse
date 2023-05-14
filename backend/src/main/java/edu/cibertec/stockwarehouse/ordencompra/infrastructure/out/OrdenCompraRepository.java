package edu.cibertec.stockwarehouse.ordencompra.infrastructure.out;

import edu.cibertec.stockwarehouse.detalleordencompra.domain.model.DetalleOrdenCompra;
import edu.cibertec.stockwarehouse.ordencompra.domain.model.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Integer> {

   }
