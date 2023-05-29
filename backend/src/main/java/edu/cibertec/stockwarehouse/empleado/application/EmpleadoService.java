package edu.cibertec.stockwarehouse.empleado.application;

import edu.cibertec.stockwarehouse.empleado.domain.dto.EmpleadoDTO;

import java.util.List;

public interface EmpleadoService {
    EmpleadoDTO find(int id);

    List<EmpleadoDTO> findAll();

    EmpleadoDTO save(EmpleadoDTO empleadoDTO);

    EmpleadoDTO update(EmpleadoDTO empleadoDTO);

    void delete(int id);
}
