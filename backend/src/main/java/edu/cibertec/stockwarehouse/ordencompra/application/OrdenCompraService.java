package edu.cibertec.stockwarehouse.ordencompra.application;


import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraDetalleDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraCreateDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraUpdateDTO;

import java.util.List;

public interface OrdenCompraService {

    List<OrdenCompraDTO> findAll();

    OrdenCompraDTO findByID(int id);

    OrdenCompraDTO save(OrdenCompraCreateDTO ordenCompraCreateDTO);

    OrdenCompraDTO update(OrdenCompraUpdateDTO ordenCompraUpdateDTO);

    OrdenCompraDetalleDTO ordenCompraConDetalle(int id);
    void delete(int id);

}
