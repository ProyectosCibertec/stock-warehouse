package edu.cibertec.stockwarehouse.cabecerainventario.application.service;

import edu.cibertec.stockwarehouse.cabecerainventario.domain.dto.CabeceraInventarioCreateDTO;
import edu.cibertec.stockwarehouse.cabecerainventario.domain.dto.CabeceraInventarioDTO;
import edu.cibertec.stockwarehouse.cabecerainventario.domain.dto.CabeceraInventarioUpdateDTO;

import java.util.List;

public interface CabeceraInventarioService {

    List<CabeceraInventarioDTO> findAll();

    CabeceraInventarioDTO findByID(int id);

    CabeceraInventarioDTO save(CabeceraInventarioCreateDTO cabeceraTnventarioCreateDTO);

    CabeceraInventarioDTO update(CabeceraInventarioUpdateDTO cabeceraTnventarioUpdateDTO);

    void delete(int id);

}
