package edu.cibertec.stockwarehouse.cabecerainventario.application.impl;

import edu.cibertec.stockwarehouse.cabecerainventario.application.service.CabeceraInventarioService;
import edu.cibertec.stockwarehouse.cabecerainventario.domain.dto.CabeceraInventarioCreateDTO;
import edu.cibertec.stockwarehouse.cabecerainventario.domain.dto.CabeceraInventarioDTO;
import edu.cibertec.stockwarehouse.cabecerainventario.domain.dto.CabeceraInventarioUpdateDTO;
import edu.cibertec.stockwarehouse.cabecerainventario.domain.mapper.CabeceraInventarioMapper;
import edu.cibertec.stockwarehouse.cabecerainventario.domain.model.CabeceraInventario;
import edu.cibertec.stockwarehouse.cabecerainventario.infrastructure.out.CabeceraInventarioRepository;
import edu.cibertec.stockwarehouse.empleado.application.EmpleadoService;
import edu.cibertec.stockwarehouse.empleado.domain.model.Empleado;
import edu.cibertec.stockwarehouse.empleado.infrastructure.out.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class CabeceraInventarioServiceImp implements CabeceraInventarioService {

    @Autowired
    private CabeceraInventarioRepository cabeceraInventarioRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;


    @Override
    public List<CabeceraInventarioDTO> findAll() {
        return CabeceraInventarioMapper.instancia.listaCabeceraInventarioACabeceraInventarioDTO(cabeceraInventarioRepository.findAll());
    }

    @Override
    public CabeceraInventarioDTO findByID(int id) {
        Optional<CabeceraInventario> cabecerainventarioOptional = cabeceraInventarioRepository.findById(id);

        if(cabecerainventarioOptional.isPresent()){
            return CabeceraInventarioMapper.instancia.cabeceraInventarioACabeceraInventarioDTO(cabecerainventarioOptional.get());
        } else{
            throw new NoResultException("No se encontro la Cabecera de inventario con id"+ id);
        }

    }

    @Override
    public CabeceraInventarioDTO save(CabeceraInventarioCreateDTO cabeceraInventarioCreateDTO) {
        CabeceraInventario cabeceraInventario = CabeceraInventarioMapper.instancia.cabeceraInventarioCreateDTOACabeceraInventario(cabeceraInventarioCreateDTO);
        Empleado empleado = empleadoRepository.findById(cabeceraInventarioCreateDTO.getIdempleado())
                .orElseThrow(()-> new NoResultException("No se encontro empleado con id:" + cabeceraInventarioCreateDTO.getIdempleado()));
        cabeceraInventario.setEmpleado(empleado);

        return CabeceraInventarioMapper.instancia.cabeceraInventarioACabeceraInventarioDTO(cabeceraInventarioRepository.save(cabeceraInventario));
    }

    @Override
    public CabeceraInventarioDTO update(CabeceraInventarioUpdateDTO cabeceraInventarioUpdateDTO) {

        CabeceraInventario cabeceraInventario = CabeceraInventarioMapper.instancia.cabeceraInventarioUpdateDTOACabeceraInventario(cabeceraInventarioUpdateDTO);
        return CabeceraInventarioMapper.instancia.cabeceraInventarioACabeceraInventarioDTO(cabeceraInventarioRepository.save(cabeceraInventario));
    }

    @Override
    public void delete(int id) {
        Optional<CabeceraInventario> cabeceraInventarioOptional = cabeceraInventarioRepository.findById(id);

        if (cabeceraInventarioOptional.isPresent()){
            cabeceraInventarioRepository.delete(cabeceraInventarioOptional.get());
        } else {
            throw new NoResultException("No se encontro la cabecera de inventario con id: "+id);
        }

    }
}
