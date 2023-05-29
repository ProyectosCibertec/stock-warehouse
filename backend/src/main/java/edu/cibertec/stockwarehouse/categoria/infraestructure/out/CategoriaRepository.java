package edu.cibertec.stockwarehouse.categoria.infraestructure.out;

import edu.cibertec.stockwarehouse.categoria.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
