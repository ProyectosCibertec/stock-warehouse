package edu.cibertec.stockwarehouse.ordencompra.application.impl;

import edu.cibertec.stockwarehouse.detalleordencompra.domain.mapper.DetalleOrdenCompraMapper;
import edu.cibertec.stockwarehouse.detalleordencompra.infrastructure.out.DetalleOrdenCompraRepositoy;
import edu.cibertec.stockwarehouse.ordencompra.application.service.OrdenCompraService;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraDetalleDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraCreateDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraUpdateDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.mapper.OrdenCompraMapper;
import edu.cibertec.stockwarehouse.ordencompra.domain.model.OrdenCompra;
import edu.cibertec.stockwarehouse.ordencompra.infrastructure.out.OrdenCompraRepository;
import edu.cibertec.stockwarehouse.proveedor.domain.model.Proveedor;
import edu.cibertec.stockwarehouse.proveedor.infrastructure.out.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class OrdenCompraServiceImpl implements OrdenCompraService {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private DetalleOrdenCompraRepositoy detalleOrdenCompraRepositoy;

    @Override
    public List<OrdenCompraDTO> findAll() {

        return OrdenCompraMapper.instancia.listaOrdenesCompraAOrdenCompraDTO(ordenCompraRepository.findAll());
    }

    @Override
    public OrdenCompraDetalleDTO ordenCompraConDetalle(int id) {
        OrdenCompra ordenCompra = ordenCompraRepository.findById(id).orElse(null);
        if (ordenCompra == null) {
            return null;
        }
        OrdenCompraDetalleDTO ordenCompraDetalleDTO = OrdenCompraMapper.instancia.OrdenComprasADetalleOrdenPorOrdenCompraDTO(ordenCompra);
        ordenCompraDetalleDTO.setListaDetallesDTO(detalleOrdenCompraRepositoy.findByordencompra(ordenCompra).stream()
                .map(DetalleOrdenCompraMapper.instancia::detalleOrdenCompraADetalleOrdenCompraDTO)
                .collect(Collectors.toList()));
        return ordenCompraDetalleDTO;
    }

    @Override
    public OrdenCompraDTO findByID(int id) {
        Optional<OrdenCompra> ordencompraOptional = ordenCompraRepository.findById(id);

        if (ordencompraOptional.isPresent()) {
            return OrdenCompraMapper.instancia.ordenCompraAOrdenCompraDTO(ordencompraOptional.get());
        } else {
            throw new NoResultException("No se encontro la ordencompra con id: " + id);
        }

    }

    @Override
    public OrdenCompraDTO save(OrdenCompraCreateDTO ordenCompraCreateDTO) {

        OrdenCompra ordenCompra = OrdenCompraMapper.instancia.ordenCompraCreateDTOAOrdenCompra(ordenCompraCreateDTO);
        Proveedor proveedor = proveedorRepository.findById(ordenCompraCreateDTO.getProveedorId())
                .orElseThrow(() -> new NoResultException("No se encontro el proveedor con id: " + ordenCompraCreateDTO.getProveedorId()));
        ordenCompra.setProveedor(proveedor);

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
        } else {
            throw new NoResultException("No se encontro la ordencompra con id: " + id);
        }
    }
}
