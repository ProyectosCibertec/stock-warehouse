package edu.cibertec.stockwarehouse.cargo.application;

import edu.cibertec.stockwarehouse.cargo.domain.dto.CargoCreateDTO;
import edu.cibertec.stockwarehouse.cargo.domain.dto.CargoDTO;
import edu.cibertec.stockwarehouse.cargo.domain.dto.CargoUpdateDTO;

import java.util.List;

public interface CargoService {
    CargoDTO find(int id);

    List<CargoDTO> findAll();

    CargoDTO save(CargoCreateDTO cargoCreateDTO);

    CargoDTO update(CargoUpdateDTO cargoUpdateDTO);

    void delete(int id);
}
