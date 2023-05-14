package edu.cibertec.stockwarehouse.Categoria.domain.mapper;

import edu.cibertec.stockwarehouse.Categoria.domain.dto.CategoriaCreateDTO;
import edu.cibertec.stockwarehouse.Categoria.domain.dto.CategoriaDTO;
import edu.cibertec.stockwarehouse.Categoria.domain.dto.CategoriaUpdateDTO;
import edu.cibertec.stockwarehouse.Categoria.domain.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoriaMapper {
    CategoriaMapper instance = Mappers.getMapper(CategoriaMapper.class);

    CategoriaDTO categoriaACategoriaDTO(Categoria categoria);

    Categoria categoriaDTOACategoria(CategoriaDTO categoriaDTO);

    Categoria categoriaUpdateDTOACategoria(CategoriaUpdateDTO categoriaUpdateDTO);

    Categoria categotiaCreateDTOACategoria(CategoriaCreateDTO categoriaCreateDTO);

    List<CategoriaDTO> listaCategoriaAlistaCategoriaDTO(List<Categoria> categoriaList);


}
