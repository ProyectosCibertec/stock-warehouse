package edu.cibertec.stockwarehouse.proveedor.application;

import edu.cibertec.stockwarehouse.proveedor.domain.dto.ProveedorCreateDTO;
import edu.cibertec.stockwarehouse.proveedor.domain.dto.ProveedorDTO;
import edu.cibertec.stockwarehouse.proveedor.domain.dto.ProveedorUpdateDTO;

import java.util.List;

public interface ProveedorService {

    List<ProveedorDTO> listarProveedores();

    ProveedorDTO obtenerProveedorPorID(long id);

    ProveedorDTO registrarProveedor(ProveedorCreateDTO proveedorCreateDTO);

    ProveedorDTO actualizarProveedor(ProveedorUpdateDTO proveedorUpdateDTO);

    String eliminarProveedor(long id);
}
