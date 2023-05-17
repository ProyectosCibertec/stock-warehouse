package edu.cibertec.stockwarehouse.detalleordencompra.domain.mapper;

import edu.cibertec.stockwarehouse.detalleordencompra.domain.dto.DetalleOrdenCompraCreateDTO;
import edu.cibertec.stockwarehouse.detalleordencompra.domain.dto.DetalleOrdenCompraDTO;
import edu.cibertec.stockwarehouse.detalleordencompra.domain.dto.DetalleOrdenCompraUpdateDTO;
import edu.cibertec.stockwarehouse.detalleordencompra.domain.model.DetalleOrdenCompra;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DetalleOrdenCompraMapper {

    DetalleOrdenCompraMapper instancia = Mappers.getMapper(DetalleOrdenCompraMapper.class);

    @Mapping(target = "ordencompraid", source = "ordencompra.id_orden_compra")
    @Mapping(target = "productoid", source = "producto.id")
    DetalleOrdenCompraDTO detalleOrdenCompraADetalleOrdenCompraDTO(DetalleOrdenCompra detalleOrdenCompra);

    DetalleOrdenCompra detalleOrdenCompraDTOADetalleOrdenCompra(DetalleOrdenCompraDTO detalleOrdenCompraDTO);

    @Mapping(target = "ordencompra.id_orden_compra", source = "detalleOrdenCompraCreateDTO.ordencompraid")
    @Mapping(target = "producto.id", source = "detalleOrdenCompraCreateDTO.productoid")
    DetalleOrdenCompra detalleOrdenCompraCreateDTOADetalleOrdenCompra(DetalleOrdenCompraCreateDTO detalleOrdenCompraCreateDTO);

    @Mapping(target = "ordencompra.id_orden_compra", source = "detalleOrdenCompraUpdateDTO.ordencompraid")
    @Mapping(target = "producto.id", source = "detalleOrdenCompraUpdateDTO.productoid")
    DetalleOrdenCompra detalleOrdenCompraUpdateDTOADetalleOrdenCompra(DetalleOrdenCompraUpdateDTO detalleOrdenCompraUpdateDTO);

    @Mapping(target = "ordencompraid", source = "ordencompra.id_orden_compra")
    @Mapping(target = "productoid", source = "producto.id")
    List<DetalleOrdenCompraDTO> listaDetallesOrdenCompraADetalleOrdenCompraDTO(List<DetalleOrdenCompra> listaDetallesOrdenCompra);

}
