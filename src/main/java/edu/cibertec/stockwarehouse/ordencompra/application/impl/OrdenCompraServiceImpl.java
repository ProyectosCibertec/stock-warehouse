package edu.cibertec.stockwarehouse.ordencompra.application.impl;

import edu.cibertec.stockwarehouse.ordencompra.application.service.OrdenCompraService;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraCreateDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraUpdateDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.mapper.OrdenCompraMapper;
import edu.cibertec.stockwarehouse.ordencompra.domain.model.OrdenCompra;
import edu.cibertec.stockwarehouse.ordencompra.infrastructure.out.OrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenCompraServiceImpl implements OrdenCompraService {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Override
    public List<OrdenCompraDTO> findAll() {
        return OrdenCompraMapper.instancia.listaOrdenesCompraAOrdenCompraDTO(ordenCompraRepository.findAll());
    }

    @Override
    public OrdenCompraDTO findByID(int id) {
        Optional<OrdenCompra> ordencompraOptional = ordenCompraRepository.findById(id);

        if (ordencompraOptional.isPresent()) {
            return OrdenCompraMapper.instancia.ordenCompraAOrdenCompraDTO(ordencompraOptional.get());
        }else {
            throw new NoResultException("No se encontro la ordencompra con id: " + id);
        }

    }

    @Override
    public OrdenCompraDTO save(OrdenCompraCreateDTO ordenCompraCreateDTO) {
        OrdenCompra ordenCompra = OrdenCompraMapper.instancia.ordenCompraCreateDTOAOrdenCompra(ordenCompraCreateDTO);
        return OrdenCompraMapper.instancia.ordenCompraAOrdenCompraDTO(ordenCompraRepository.save(ordenCompra));
    }

    @Override
    public OrdenCompraDTO update(OrdenCompraUpdateDTO ordenCompraUpdateDTO) {

        OrdenCompra ordenCompra = OrdenCompraMapper.instancia.ordenCompraUpdateDTOAOrdenCompra(ordenCompraUpdateDTO);
        return OrdenCompraMapper.instancia.ordenCompraAOrdenCompraDTO(ordenCompraRepository.save(ordenCompra));
    }

    @Override
    public void delete(int id) {
        Optional<OrdenCompra> ordenCompraOptional = ordenCompraRepository.findById(id);

        if (ordenCompraOptional.isPresent()) {
           ordenCompraRepository.delete(ordenCompraOptional.get());
        }else {
            throw new NoResultException("No se encontro la ordencompra con id: " + id);
        }
    }
}
