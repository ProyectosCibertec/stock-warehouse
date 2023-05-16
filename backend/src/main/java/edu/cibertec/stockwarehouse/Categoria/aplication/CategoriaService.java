package edu.cibertec.stockwarehouse.Categoria.aplication;

import edu.cibertec.stockwarehouse.Categoria.domain.dto.CategoriaCreateDTO;
import edu.cibertec.stockwarehouse.Categoria.domain.dto.CategoriaDTO;
import edu.cibertec.stockwarehouse.Categoria.domain.dto.CategoriaUpdateDTO;

import java.util.List;

public interface CategoriaService {
    CategoriaDTO find(int id);

    List<CategoriaDTO> findAll();

    CategoriaDTO save(CategoriaCreateDTO categoriaCreateDTO);

    CategoriaDTO update(CategoriaUpdateDTO categoriaUpdateDTO);

    void delete(int id);
}
