package edu.cibertec.stockwarehouse.Producto.domain.mapper;

import edu.cibertec.stockwarehouse.Producto.domain.dto.ProductoCreateDTO;
import edu.cibertec.stockwarehouse.Producto.domain.dto.ProductoDTO;
import edu.cibertec.stockwarehouse.Producto.domain.dto.ProductoUpdateDTO;
import edu.cibertec.stockwarehouse.Producto.domain.model.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductoMapper {
    ProductoMapper instance = Mappers.getMapper(ProductoMapper.class);

    ProductoDTO productoAProductoDTO(Producto producto);

    Producto productoDTOProducto(ProductoDTO productoDTO);

    Producto productoUpdateDTOAProducto(ProductoUpdateDTO productoUpdateDTO);

    Producto productoCreateDTOAProducto(ProductoCreateDTO productoCreateDTO);

    List<ProductoDTO> listaProductoAListaProductoDTO(List<Producto> productoList);

}
