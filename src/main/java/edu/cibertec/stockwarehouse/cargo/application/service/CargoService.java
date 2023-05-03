package edu.cibertec.stockwarehouse.cargo.application.service;

import edu.cibertec.stockwarehouse.cargo.domain.Cargo;
import edu.cibertec.stockwarehouse.empleado.model.Empleado;

import java.util.List;

public interface CargoService {
    Cargo find(int id);
    List<Cargo> findAll();
    Cargo save(Cargo cargo);
    void delete(int id);
}
