package edu.cibertec.stockwarehouse.cargo.application;

import edu.cibertec.stockwarehouse.cargo.domain.dto.CargoDTO;

import java.util.List;

public interface CargoService {
    CargoDTO find(int id);

    List<CargoDTO> findAll();

    CargoDTO save(CargoDTO cargoDTO);

    CargoDTO update(CargoDTO cargoDTO);

    void delete(int id);
}
