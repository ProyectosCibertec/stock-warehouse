package edu.cibertec.stockwarehouse.ordencompra.domain.mapper;

import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraDetalleDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraCreateDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraUpdateDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.model.OrdenCompra;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrdenCompraMapper {

    OrdenCompraMapper instancia = Mappers.getMapper(OrdenCompraMapper.class);

    @Mapping(target = "nomproveedor", source = "proveedor.razonSocial")
    OrdenCompraDTO ordenCompraAOrdenCompraDTO(OrdenCompra ordenCompra);


    OrdenCompra ordenCompraDTOAOrdenCompra(OrdenCompraDTO ordenCompraDTO);


    @Mapping(target = "proveedor.id", source = "oredenOrdenCompraCreateDTO.proveedorId")
    OrdenCompra ordenCompraCreateDTOAOrdenCompra(OrdenCompraCreateDTO oredenOrdenCompraCreateDTO);


    @Mapping(target = "proveedor.id", source = "ordenCompraUpdateDTO.proveedorId")
    OrdenCompra ordenCompraUpdateDTOAOrdenCompra(OrdenCompraUpdateDTO ordenCompraUpdateDTO);

    @Mapping(target = "nomproveedor", source = "proveedor.razonSocial")
    List<OrdenCompraDTO> listaOrdenesCompraAOrdenCompraDTO(List<OrdenCompra> listaOrdenCompras);

    OrdenCompraDetalleDTO OrdenComprasADetalleOrdenPorOrdenCompraDTO(OrdenCompra ordenCompra);
}
