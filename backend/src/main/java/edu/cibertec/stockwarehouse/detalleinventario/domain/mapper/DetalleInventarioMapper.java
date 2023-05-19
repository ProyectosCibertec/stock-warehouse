package edu.cibertec.stockwarehouse.detalleinventario.domain.mapper;


import edu.cibertec.stockwarehouse.detalleinventario.domain.dto.DetalleInventarioCreateDTO;
import edu.cibertec.stockwarehouse.detalleinventario.domain.dto.DetalleInventarioDTO;
import edu.cibertec.stockwarehouse.detalleinventario.domain.dto.DetalleInventarioUpdateDTO;
import edu.cibertec.stockwarehouse.detalleinventario.domain.model.DetalleInventario;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface DetalleInventarioMapper {

    DetalleInventarioMapper instancia = Mappers.getMapper(DetalleInventarioMapper.class);

    DetalleInventarioDTO detalleInvantarioDetalleInventarioDTO(DetalleInventario detalleInventario);
    DetalleInventario detalleInventarioDTOADetalleInventario(DetalleInventarioDTO detalleInventarioDTO);

    DetalleInventario detalleInventarioCreateDTOADetalleInventario(DetalleInventarioCreateDTO detalleInventarioCreateDTO);

    DetalleInventario detalleInventarioUpdateDTOADetalleInventario(DetalleInventarioUpdateDTO detalleInventarioUpdateDTO);

    List<DetalleInventarioDTO> listaDetalleInventarioADetalleInventarioDTO(List<DetalleInventario> listaDetalleInventario);
}
