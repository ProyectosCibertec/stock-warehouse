package edu.cibertec.stockwarehouse.cabecerainventario.domain.mapper;

import edu.cibertec.stockwarehouse.cabecerainventario.domain.dto.CabeceraInventarioCreateDTO;
import edu.cibertec.stockwarehouse.cabecerainventario.domain.dto.CabeceraInventarioDTO;
import edu.cibertec.stockwarehouse.cabecerainventario.domain.dto.CabeceraInventarioUpdateDTO;
import edu.cibertec.stockwarehouse.cabecerainventario.domain.model.CabeceraInventario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CabeceraInventarioMapper {

    CabeceraInventarioMapper instancia = Mappers.getMapper(CabeceraInventarioMapper.class);

    @Mapping(target = "nomempleado",source = "empleado.nombre")
    CabeceraInventarioDTO cabeceraInventarioACabeceraInventarioDTO(CabeceraInventario cabeceraInventario);

    CabeceraInventario cabeceraInventarioDTOACabeceraInventario(CabeceraInventarioDTO cabeceraInventarioDTO);

    @Mapping(target = "empleado.id", source = "cabcabeceraInventarioCreateDTO.idempleado")
    CabeceraInventario cabeceraInventarioCreateDTOACabeceraInventario(CabeceraInventarioCreateDTO cabcabeceraInventarioCreateDTO);

    @Mapping (target = "empleado.id", source = "cabeceraInventarioUpdateDTO.idempleado")
    CabeceraInventario cabeceraInventarioUpdateDTOACabeceraInventario(CabeceraInventarioUpdateDTO cabeceraInventarioUpdateDTO);

    @Mapping(target = "nomempleado",source = "empleado.nombre")
    List<CabeceraInventarioDTO> listaCabeceraInventarioACabeceraInventarioDTO(List<CabeceraInventario> listaCabeceraInventario);
}
