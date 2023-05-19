package edu.cibertec.stockwarehouse.detalleinventario.application.service;

import edu.cibertec.stockwarehouse.detalleinventario.domain.dto.DetalleInventarioCreateDTO;
import edu.cibertec.stockwarehouse.detalleinventario.domain.dto.DetalleInventarioDTO;
import edu.cibertec.stockwarehouse.detalleinventario.domain.dto.DetalleInventarioUpdateDTO;


import java.util.List;

public interface DetalleInventarioService {

    List<DetalleInventarioDTO> findAll();

    DetalleInventarioDTO findByID (int id);

    DetalleInventarioDTO save(DetalleInventarioCreateDTO detalleInventarioCreateDTO);

    DetalleInventarioDTO update(DetalleInventarioUpdateDTO detalleInventarioUpdateDTO);

    void delete(int id);
}
