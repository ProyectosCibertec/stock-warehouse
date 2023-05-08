package edu.cibertec.stockwarehouse.empleado.application.impl;

import edu.cibertec.stockwarehouse.empleado.application.EmpleadoService;
import edu.cibertec.stockwarehouse.empleado.domain.dto.EmpleadoCreateDTO;
import edu.cibertec.stockwarehouse.empleado.domain.dto.EmpleadoDTO;
import edu.cibertec.stockwarehouse.empleado.domain.dto.EmpleadoUpdateDTO;
import edu.cibertec.stockwarehouse.empleado.domain.mapper.EmpleadoMapper;
import edu.cibertec.stockwarehouse.empleado.domain.model.Empleado;
import edu.cibertec.stockwarehouse.empleado.infrastructure.out.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public EmpleadoDTO find(int id) {
        Optional<Empleado> pivot = empleadoRepository.findById(id);
        if (pivot.isPresent()) {
            return EmpleadoMapper.instance.empleadoAEmpleadoDTO(pivot.get());
        }
        throw new NoResultException();
    }

    @Override
    public List<EmpleadoDTO> findAll() {
        return EmpleadoMapper.instance.listaEmpleadoAListaEmpleadoDTO(empleadoRepository.findAll());
    }

    @Override
    public EmpleadoDTO save(EmpleadoCreateDTO empleadoCreateDTO) {
        Empleado empleado = EmpleadoMapper.instance.empleadoCreateDTOAEmpleado(empleadoCreateDTO);
        return EmpleadoMapper.instance.empleadoAEmpleadoDTO(empleadoRepository.save(empleado));
    }

    @Override
    public EmpleadoDTO update(EmpleadoUpdateDTO empleadoUpdateDTO) {
        Empleado empleado = EmpleadoMapper.instance.empleadoUpdateDTOAEmpleado(empleadoUpdateDTO);
        return EmpleadoMapper.instance.empleadoAEmpleadoDTO(empleadoRepository.save(empleado));
    }

    @Override
    public void delete(int id) {
        empleadoRepository.deleteById(id);
    }
}
