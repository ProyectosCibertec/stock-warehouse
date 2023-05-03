package edu.cibertec.stockwarehouse.empleado.application;

import edu.cibertec.stockwarehouse.empleado.domain.dto.EmpleadoCreateDTO;
import edu.cibertec.stockwarehouse.empleado.domain.dto.EmpleadoDTO;
import edu.cibertec.stockwarehouse.empleado.domain.dto.EmpleadoUpdateDTO;
import edu.cibertec.stockwarehouse.empleado.domain.model.Empleado;

import java.util.List;

public interface EmpleadoService {
    EmpleadoDTO find(int id);
    List<EmpleadoDTO> findAll();
    EmpleadoDTO save(EmpleadoCreateDTO empleadoCreateDTO);
    EmpleadoDTO update(EmpleadoUpdateDTO empleadoUpdateDTO);
    void delete(int id);
}
