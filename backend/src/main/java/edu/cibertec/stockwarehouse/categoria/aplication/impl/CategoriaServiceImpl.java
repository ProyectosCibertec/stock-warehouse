package edu.cibertec.stockwarehouse.categoria.aplication.impl;

import edu.cibertec.stockwarehouse.categoria.aplication.CategoriaService;
import edu.cibertec.stockwarehouse.categoria.domain.dto.CategoriaCreateDTO;
import edu.cibertec.stockwarehouse.categoria.domain.dto.CategoriaDTO;
import edu.cibertec.stockwarehouse.categoria.domain.dto.CategoriaUpdateDTO;
import edu.cibertec.stockwarehouse.categoria.domain.mapper.CategoriaMapper;
import edu.cibertec.stockwarehouse.categoria.domain.model.Categoria;
import edu.cibertec.stockwarehouse.categoria.infraestructure.out.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public CategoriaDTO find(int id) {
        Optional<Categoria> pivot = categoriaRepository.findById(id);
        if (pivot.isPresent()) {
            return CategoriaMapper.instance.categoriaACategoriaDTO(pivot.get());
        }
        throw new NoResultException();
    }

    @Override
    public List<CategoriaDTO> findAll() {
        return CategoriaMapper.instance.listaCategoriaAlistaCategoriaDTO(categoriaRepository.findAll());
    }

    @Override
    public CategoriaDTO save(CategoriaCreateDTO categoriaCreateDTO) {
        Categoria categoria = CategoriaMapper.instance.categotiaCreateDTOACategoria(categoriaCreateDTO);
        return CategoriaMapper.instance.categoriaACategoriaDTO(categoriaRepository.save(categoria));
    }

    @Override
    public CategoriaDTO update(CategoriaUpdateDTO categoriaUpdateDTO) {
        Categoria categoria = CategoriaMapper.instance.categoriaUpdateDTOACategoria(categoriaUpdateDTO);
        return CategoriaMapper.instance.categoriaACategoriaDTO(categoriaRepository.save(categoria));
    }

    @Override
    public void delete(int id) {
        categoriaRepository.deleteById(id);
    }
}
