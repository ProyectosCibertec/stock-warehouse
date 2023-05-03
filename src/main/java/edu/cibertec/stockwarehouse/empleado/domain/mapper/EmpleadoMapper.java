package edu.cibertec.stockwarehouse.empleado.domain.mapper;

import edu.cibertec.stockwarehouse.empleado.domain.dto.EmpleadoCreateDTO;
import edu.cibertec.stockwarehouse.empleado.domain.dto.EmpleadoDTO;
import edu.cibertec.stockwarehouse.empleado.domain.dto.EmpleadoUpdateDTO;
import edu.cibertec.stockwarehouse.empleado.domain.model.Empleado;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmpleadoMapper {
    EmpleadoMapper instance = Mappers.getMapper(EmpleadoMapper.class);
    EmpleadoDTO empleadoAEmpleadoDTO(Empleado empleado);
    Empleado empleadoDTOAEmpleado(EmpleadoDTO empleadoDTO);
    Empleado empleadoUpdateDTOAEmpleado(EmpleadoUpdateDTO empleadoUpdateDTO);
    Empleado empleadoCreateDTOAEmpleado(EmpleadoCreateDTO empleadoCreateDTO);
    List<EmpleadoDTO> listaEmpleadoAListaEmpleadoDTO(List<Empleado> empleadoList);
}
