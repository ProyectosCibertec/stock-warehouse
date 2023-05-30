package edu.cibertec.stockwarehouse.producto.application;

import edu.cibertec.stockwarehouse.producto.domain.dto.ProductoCreateDTO;
import edu.cibertec.stockwarehouse.producto.domain.dto.ProductoDTO;
import edu.cibertec.stockwarehouse.producto.domain.dto.ProductoUpdateDTO;

import java.util.List;

public interface ProductoService {


    ProductoDTO find(int id);

    List<ProductoDTO> findAll();

    ProductoDTO save(ProductoCreateDTO productoCreateDTO);

    ProductoDTO update(ProductoUpdateDTO productoUpdateDTO);

    void delete(int id);

}
