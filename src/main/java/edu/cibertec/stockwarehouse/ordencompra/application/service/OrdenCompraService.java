package edu.cibertec.stockwarehouse.ordencompra.application.service;


import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraCreateDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraUpdateDTO;

import java.util.List;

public interface OrdenCompraService {

    List<OrdenCompraDTO> findAll();

    OrdenCompraDTO findByID(int id);

    OrdenCompraDTO save(OrdenCompraCreateDTO ordenCompraCreateDTO);

    OrdenCompraDTO update(OrdenCompraUpdateDTO ordenCompraUpdateDTO);

    void delete(int id);

}
