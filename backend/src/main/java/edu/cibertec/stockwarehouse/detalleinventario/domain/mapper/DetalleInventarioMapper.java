package edu.cibertec.stockwarehouse.detalleinventario.domain.mapper;


import edu.cibertec.stockwarehouse.detalleinventario.domain.dto.DetalleInventarioCreateDTO;
import edu.cibertec.stockwarehouse.detalleinventario.domain.dto.DetalleInventarioDTO;
import edu.cibertec.stockwarehouse.detalleinventario.domain.dto.DetalleInventarioUpdateDTO;
import edu.cibertec.stockwarehouse.detalleinventario.domain.model.DetalleInventario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DetalleInventarioMapper {

    DetalleInventarioMapper instancia = Mappers.getMapper(DetalleInventarioMapper.class);

    @Mapping(target = "id_cab_inventario", source="cabecerainventario.id_cab_inventario")
    @Mapping(target = "id_producto", source = "producto.id")
    DetalleInventarioDTO detalleInvantarioDetalleInventarioDTO(DetalleInventario detalleInventario);


    DetalleInventario detalleInventarioDTOADetalleInventario(DetalleInventarioDTO detalleInventarioDTO);

    @Mapping(target = "cabecerainventario.id_cab_inventario",source = "detalleInventarioCreateDTO.id_cab_inventario")
    @Mapping(target = "producto.id",source = "detalleInventarioCreateDTO.id_producto")
    DetalleInventario detalleInventarioCreateDTOADetalleInventario(DetalleInventarioCreateDTO detalleInventarioCreateDTO);

    @Mapping(target = "cabecerainventario.id_cab_inventario",source = "detalleInventarioUpdateDTO.id_cab_inventario")
    @Mapping(target = "producto.id",source = "detalleInventarioUpdateDTO.id_producto")
    DetalleInventario detalleInventarioUpdateDTOADetalleInventario(DetalleInventarioUpdateDTO detalleInventarioUpdateDTO);

    @Mapping(target = "id_cab_inventario", source="cabecerainventario.id_cab_inventario")
    @Mapping(target = "id_producto", source = "producto.id")
    List<DetalleInventarioDTO> listaDetalleInventarioADetalleInventarioDTO(List<DetalleInventario> listaDetalleInventario);
}
