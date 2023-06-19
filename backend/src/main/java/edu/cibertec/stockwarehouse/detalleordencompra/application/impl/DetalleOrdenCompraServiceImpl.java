package edu.cibertec.stockwarehouse.detalleordencompra.application.impl;

import edu.cibertec.stockwarehouse.detalleordencompra.application.DetalleOrdenCompraService;
import edu.cibertec.stockwarehouse.detalleordencompra.domain.dto.DetalleOrdenCompraCreateDTO;
import edu.cibertec.stockwarehouse.detalleordencompra.domain.dto.DetalleOrdenCompraDTO;
import edu.cibertec.stockwarehouse.detalleordencompra.domain.dto.DetalleOrdenCompraUpdateDTO;
import edu.cibertec.stockwarehouse.detalleordencompra.domain.mapper.DetalleOrdenCompraMapper;
import edu.cibertec.stockwarehouse.detalleordencompra.domain.model.DetalleOrdenCompra;
import edu.cibertec.stockwarehouse.detalleordencompra.infrastructure.out.DetalleOrdenCompraRepository;
import edu.cibertec.stockwarehouse.ordencompra.domain.model.OrdenCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleOrdenCompraServiceImpl implements DetalleOrdenCompraService {

    @Autowired
    private DetalleOrdenCompraRepository detalleOrdenCompraRepositoy;

    @Override
    public List<DetalleOrdenCompraDTO> findAll() {
        return DetalleOrdenCompraMapper.instancia.listaDetallesOrdenCompraADetalleOrdenCompraDTO(detalleOrdenCompraRepositoy.findAll());
    }

    @Override
    public DetalleOrdenCompraDTO findByID(int id) {
        Optional<DetalleOrdenCompra> detalleOrdenCompraOptional = detalleOrdenCompraRepositoy.findById(id);

        if (detalleOrdenCompraOptional.isPresent()) {
            return DetalleOrdenCompraMapper.instancia.detalleOrdenCompraADetalleOrdenCompraDTO(detalleOrdenCompraOptional.get());
        } else {
            throw new NoResultException("No se encintro el detalle con id: " + id);
        }
    }

    @Override
    public DetalleOrdenCompraDTO save(DetalleOrdenCompraCreateDTO detalleOrdenCompraCreateDTO) {

        DetalleOrdenCompra detalleOrdenCompra = DetalleOrdenCompraMapper.instancia
                .detalleOrdenCompraCreateDTOADetalleOrdenCompra(detalleOrdenCompraCreateDTO);

        return DetalleOrdenCompraMapper.instancia.detalleOrdenCompraADetalleOrdenCompraDTO(detalleOrdenCompraRepositoy.save(detalleOrdenCompra));
    }

    @Override
    public DetalleOrdenCompraDTO update(DetalleOrdenCompraUpdateDTO detalleOrdenCompraUpdateDTO) {
        DetalleOrdenCompra detalleOrdenCompra = DetalleOrdenCompraMapper.instancia
                .detalleOrdenCompraUpdateDTOADetalleOrdenCompra(detalleOrdenCompraUpdateDTO);

        return DetalleOrdenCompraMapper.instancia.detalleOrdenCompraADetalleOrdenCompraDTO(detalleOrdenCompraRepositoy.save(detalleOrdenCompra));
    }

    @Override
    @Transactional
    public void delete(int id) {
        Optional<DetalleOrdenCompra> detalleOrdenCompraOptional = detalleOrdenCompraRepositoy.findById(id);

        if (detalleOrdenCompraOptional.isPresent()) {
            DetalleOrdenCompra detalleOrdenCompra = detalleOrdenCompraOptional.get();
            OrdenCompra ordenCompra = detalleOrdenCompra.getOrdencompra();

            // Actualizar el valor total de la orden de compra
            BigDecimal detalleOrdenCompraPrecio = detalleOrdenCompra.getCosto_detalleorden();
            BigDecimal ordenCompraTotal = ordenCompra.getValortotal_orden();
            BigDecimal nuevoTotal = ordenCompraTotal.subtract(detalleOrdenCompraPrecio);
            ordenCompra.setValortotal_orden(nuevoTotal);

            // Eliminar el detalleOrdenCompra
            detalleOrdenCompraRepositoy.delete(detalleOrdenCompra);
        } else {
            throw new NoResultException("No se encontro el detalleOrdenCompra con id: " + id);
        }
    }
}
