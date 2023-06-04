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

    DetalleOrdenCompraDTO detalleOrdenCompraADetalleOrdenCompraDTO(DetalleOrdenCompra detalleOrdenCompra);

    DetalleOrdenCompra detalleOrdenCompraDTOADetalleOrdenCompra(DetalleOrdenCompraDTO detalleOrdenCompraDTO);

    DetalleOrdenCompra detalleOrdenCompraCreateDTOADetalleOrdenCompra(DetalleOrdenCompraCreateDTO detalleOrdenCompraCreateDTO);

    DetalleOrdenCompra detalleOrdenCompraUpdateDTOADetalleOrdenCompra(DetalleOrdenCompraUpdateDTO detalleOrdenCompraUpdateDTO);

    List<DetalleOrdenCompraDTO> listaDetallesOrdenCompraADetalleOrdenCompraDTO(List<DetalleOrdenCompra> listaDetallesOrdenCompra);
}
