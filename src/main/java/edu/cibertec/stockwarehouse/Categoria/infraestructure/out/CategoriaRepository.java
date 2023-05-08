package edu.cibertec.stockwarehouse.Categoria.infraestructure.out;

import edu.cibertec.stockwarehouse.Categoria.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Integer> {
}
