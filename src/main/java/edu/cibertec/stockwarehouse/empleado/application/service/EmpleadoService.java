package edu.cibertec.stockwarehouse.empleado.application.service;

import edu.cibertec.stockwarehouse.empleado.model.Empleado;

import java.util.List;

public interface EmpleadoService {
    Empleado find(int id);
    List<Empleado> findAll();
    Empleado save(Empleado empleado);
    void delete(int id);
}
