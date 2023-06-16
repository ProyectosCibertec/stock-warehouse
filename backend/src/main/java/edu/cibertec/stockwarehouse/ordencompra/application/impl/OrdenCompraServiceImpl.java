package edu.cibertec.stockwarehouse.ordencompra.application.impl;

import edu.cibertec.stockwarehouse.detalleordencompra.domain.dto.DetalleOrdenCompraCreateDTO;
import edu.cibertec.stockwarehouse.detalleordencompra.domain.dto.DetalleOrdenCompraDTO;
import edu.cibertec.stockwarehouse.detalleordencompra.domain.mapper.DetalleOrdenCompraMapper;
import edu.cibertec.stockwarehouse.detalleordencompra.domain.model.DetalleOrdenCompra;
import edu.cibertec.stockwarehouse.detalleordencompra.infrastructure.out.DetalleOrdenCompraRepository;
import edu.cibertec.stockwarehouse.ordencompra.application.OrdenCompraService;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraCreateDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraDetalleDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraUpdateDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.mapper.OrdenCompraMapper;
import edu.cibertec.stockwarehouse.ordencompra.domain.model.OrdenCompra;
import edu.cibertec.stockwarehouse.ordencompra.infrastructure.out.OrdenCompraRepository;
import edu.cibertec.stockwarehouse.proveedor.domain.model.Proveedor;
import edu.cibertec.stockwarehouse.proveedor.infrastructure.out.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
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
    private DetalleOrdenCompraRepository detalleOrdenCompraRepositoy;

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
    @Transactional
    public OrdenCompraDTO save(OrdenCompraCreateDTO ordenCompraCreateDTO) {

        OrdenCompra ordenCompra = OrdenCompraMapper.instancia.ordenCompraCreateDTOAOrdenCompra(ordenCompraCreateDTO);
        Proveedor proveedor = proveedorRepository.findById(ordenCompraCreateDTO.getProveedor().getId())
                .orElseThrow(() -> new NoResultException("No se encontro el proveedor con id: " + ordenCompraCreateDTO.getProveedor().getId()));
        ordenCompra.setProveedor(proveedor);

        OrdenCompra respuestaEntity =  ordenCompraRepository.save(ordenCompra);

        //OrdenCompraDTO resp = OrdenCompraMapper.instancia.ordenCompraAOrdenCompraDTO();

        for ( DetalleOrdenCompraCreateDTO ordendetalleDTO : ordenCompraCreateDTO.getOrdenCompraDetalleDTOList()) {
            DetalleOrdenCompra ordeDetalle =
                    DetalleOrdenCompraMapper.instancia.detalleOrdenCompraCreateDTOADetalleOrdenCompra(ordendetalleDTO);
            ordeDetalle.setOrdencompra(respuestaEntity);
            detalleOrdenCompraRepositoy.save(ordeDetalle);
        }

        OrdenCompraDTO resp = OrdenCompraMapper.instancia.ordenCompraAOrdenCompraDTO(ordenCompraRepository.getById(respuestaEntity.getId_orden_compra()));
            resp.setOrdenCompraDetalleDTOList(
                    DetalleOrdenCompraMapper.instancia.listaDetallesOrdenCompraADetalleOrdenCompraDTO(detalleOrdenCompraRepositoy.findByordencompra(respuestaEntity))
                    );

        return resp;
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
