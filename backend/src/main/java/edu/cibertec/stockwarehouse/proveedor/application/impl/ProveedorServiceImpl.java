package edu.cibertec.stockwarehouse.proveedor.application.impl;

import edu.cibertec.stockwarehouse.ordencompra.domain.model.OrdenCompra;
import edu.cibertec.stockwarehouse.proveedor.application.ProveedorService;
import edu.cibertec.stockwarehouse.proveedor.domain.dto.ProveedorCreateDTO;
import edu.cibertec.stockwarehouse.proveedor.domain.dto.ProveedorDTO;
import edu.cibertec.stockwarehouse.proveedor.domain.dto.ProveedorUpdateDTO;
import edu.cibertec.stockwarehouse.proveedor.domain.mapper.ProveedorMapper;
import edu.cibertec.stockwarehouse.proveedor.domain.model.Proveedor;
import edu.cibertec.stockwarehouse.proveedor.infrastructure.out.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<ProveedorDTO> listarProveedores() {
        return ProveedorMapper.instancia.listaProveedorAListaProveedorDTO(proveedorRepository.findAll());
    }

    @Override
    public ProveedorDTO obtenerProveedorPorID(long id) {
        Optional<Proveedor> proveedor = proveedorRepository.findById(id);
        ProveedorDTO proveedorDTO;
        if (proveedor.isPresent()) {
            proveedorDTO = ProveedorMapper.instancia.proveedorAProveedorDTO(proveedor.get());
        } else {
            proveedorDTO = null;
        }
        return proveedorDTO;
    }

    @Override
    public ProveedorDTO registrarProveedor(ProveedorCreateDTO proveedorCreateDTO) {
        Proveedor proveedor = ProveedorMapper.instancia.proveedorCreateDTOAProveedor(proveedorCreateDTO);
        Proveedor respuestaEntity = proveedorRepository.save(proveedor);
        ProveedorDTO respuestaDTO = ProveedorMapper.instancia.proveedorAProveedorDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public ProveedorDTO actualizarProveedor(ProveedorUpdateDTO proveedorUpdateDTO) {
        Proveedor cliente = ProveedorMapper.instancia.proveedorUpdateDTOAProveedor(proveedorUpdateDTO);
        Proveedor respuestaEntity = proveedorRepository.save(cliente);
        ProveedorDTO respuestaDTO = ProveedorMapper.instancia.proveedorAProveedorDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public void delete(long id) {
        Optional<Proveedor> proveedorOptional = proveedorRepository.findById(id);

        if (proveedorOptional.isPresent()) {
            proveedorRepository.delete(proveedorOptional.get());
        } else {
            throw new NoResultException("No se encontro el proveedor con id: " + id);
        }
    }
}
