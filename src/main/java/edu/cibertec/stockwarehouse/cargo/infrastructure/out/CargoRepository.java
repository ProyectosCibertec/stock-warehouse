package edu.cibertec.stockwarehouse.cargo.infrastructure.out;

import edu.cibertec.stockwarehouse.cargo.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
}
