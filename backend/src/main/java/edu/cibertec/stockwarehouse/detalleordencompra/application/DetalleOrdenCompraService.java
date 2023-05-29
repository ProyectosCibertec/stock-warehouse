package edu.cibertec.stockwarehouse.detalleordencompra.application;

import edu.cibertec.stockwarehouse.detalleordencompra.domain.dto.DetalleOrdenCompraCreateDTO;
import edu.cibertec.stockwarehouse.detalleordencompra.domain.dto.DetalleOrdenCompraDTO;
import edu.cibertec.stockwarehouse.detalleordencompra.domain.dto.DetalleOrdenCompraUpdateDTO;

import java.util.List;

public interface DetalleOrdenCompraService {

    List<DetalleOrdenCompraDTO> findAll();

    DetalleOrdenCompraDTO findByID(int id);

    DetalleOrdenCompraDTO save(DetalleOrdenCompraCreateDTO detalleOrdenCompraCreateDTO);

    DetalleOrdenCompraDTO update(DetalleOrdenCompraUpdateDTO detalleOrdenCompraUpdateDTO);

    void delete(int id);
}

