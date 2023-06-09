package edu.cibertec.stockwarehouse.categoria.aplication;

import edu.cibertec.stockwarehouse.categoria.domain.dto.CategoriaCreateDTO;
import edu.cibertec.stockwarehouse.categoria.domain.dto.CategoriaDTO;
import edu.cibertec.stockwarehouse.categoria.domain.dto.CategoriaUpdateDTO;

import java.util.List;

public interface CategoriaService {
    CategoriaDTO find(int id);

    List<CategoriaDTO> findAll();

    CategoriaDTO save(CategoriaCreateDTO categoriaCreateDTO);

    CategoriaDTO update(CategoriaUpdateDTO categoriaUpdateDTO);

    void delete(int id);
}
