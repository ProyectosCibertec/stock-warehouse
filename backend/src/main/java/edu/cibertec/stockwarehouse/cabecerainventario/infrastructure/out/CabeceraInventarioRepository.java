package edu.cibertec.stockwarehouse.cabecerainventario.infrastructure.out;

import edu.cibertec.stockwarehouse.cabecerainventario.domain.model.CabeceraInventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabeceraInventarioRepository extends JpaRepository<CabeceraInventario, Integer> {
}
