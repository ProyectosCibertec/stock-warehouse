package edu.cibertec.stockwarehouse.empleado.application.impl;

import edu.cibertec.stockwarehouse.empleado.application.service.EmpleadoService;
import edu.cibertec.stockwarehouse.empleado.infrastructure.out.EmpleadoRepository;
import edu.cibertec.stockwarehouse.empleado.model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;


    @Override
    public Empleado find(int id) {
        Optional<Empleado> pivot = empleadoRepository.findById(id);
        if (pivot.isPresent()) {
            return pivot.get();
        }
        throw new RuntimeException();
    }

    @Override
    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void delete(int id) {
        empleadoRepository.deleteById(id);
    }
}
