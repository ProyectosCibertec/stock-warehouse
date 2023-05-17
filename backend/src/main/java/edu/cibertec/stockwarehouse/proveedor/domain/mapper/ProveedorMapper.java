package edu.cibertec.stockwarehouse.proveedor.domain.mapper;

import edu.cibertec.stockwarehouse.proveedor.domain.dto.ProveedorCreateDTO;
import edu.cibertec.stockwarehouse.proveedor.domain.dto.ProveedorDTO;
import edu.cibertec.stockwarehouse.proveedor.domain.dto.ProveedorUpdateDTO;
import edu.cibertec.stockwarehouse.proveedor.domain.model.Proveedor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProveedorMapper {
    ProveedorMapper instancia = Mappers.getMapper(ProveedorMapper.class);

    ProveedorDTO proveedorAProveedorDTO(Proveedor proveedor);

    Proveedor proveedorDTOAProveedor(ProveedorDTO proveedorDTO);

    Proveedor proveedorCreateDTOAProveedor(ProveedorCreateDTO proveedorCreateDTO);

    Proveedor proveedorUpdateDTOAProveedor(ProveedorUpdateDTO proveedorUpdateDTO);

    List<ProveedorDTO> listaProveedorAListaProveedorDTO(List<Proveedor> listaProveedor);
}
