package edu.cibertec.stockwarehouse.Producto.application.impl;

import edu.cibertec.stockwarehouse.Producto.application.ProductoService;
import edu.cibertec.stockwarehouse.Producto.domain.dto.ProductoCreateDTO;
import edu.cibertec.stockwarehouse.Producto.domain.dto.ProductoDTO;
import edu.cibertec.stockwarehouse.Producto.domain.dto.ProductoUpdateDTO;
import edu.cibertec.stockwarehouse.Producto.domain.mapper.ProductoMapper;
import edu.cibertec.stockwarehouse.Producto.domain.model.Producto;
import edu.cibertec.stockwarehouse.Producto.infrastructure.out.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public ProductoDTO find(int id) {
        Optional<Producto> pivot = productoRepository.findById(id);
        if (pivot.isPresent()) {
            return ProductoMapper.instance.productoAProductoDTO(pivot.get());
        }
        throw new NoResultException();
    }

    @Override
    public List<ProductoDTO> findAll() {
        return ProductoMapper.instance.listaProductoAListaProductoDTO(productoRepository.findAll());
    }

    @Override
    public ProductoDTO save(ProductoCreateDTO productoCreateDTO) {
        Producto producto = ProductoMapper.instance.productoCreateDTOAProducto(productoCreateDTO);
        return ProductoMapper.instance.productoAProductoDTO(productoRepository.save(producto));
    }

    @Override
    public ProductoDTO update(ProductoUpdateDTO productoUpdateDTO) {
        Producto producto = ProductoMapper.instance.productoUpdateDTOAProducto(productoUpdateDTO);
        return ProductoMapper.instance.productoAProductoDTO(productoRepository.save(producto));
    }

    @Override
    public void delete(int id) {
        productoRepository.deleteById(id);
    }
}
