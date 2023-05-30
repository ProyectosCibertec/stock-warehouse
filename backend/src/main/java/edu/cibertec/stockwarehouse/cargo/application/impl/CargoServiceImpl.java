package edu.cibertec.stockwarehouse.cargo.application.impl;

import edu.cibertec.stockwarehouse.cargo.application.CargoService;
import edu.cibertec.stockwarehouse.cargo.domain.dto.CargoDTO;
import edu.cibertec.stockwarehouse.cargo.domain.mapper.CargoMapper;
import edu.cibertec.stockwarehouse.cargo.domain.model.Cargo;
import edu.cibertec.stockwarehouse.cargo.infrastructure.out.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class CargoServiceImpl implements CargoService {
    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public CargoDTO find(int id) {
        Optional<Cargo> pivot = cargoRepository.findById(id);
        if (pivot.isPresent()) {
            return CargoMapper.instance.cargoACargoDTO(pivot.get());
        }
        throw new NoResultException();
    }

    @Override
    public List<CargoDTO> findAll() {
        return CargoMapper.instance.listaCargoAListaCargoDTO(cargoRepository.findAll());
    }

    @Override
    public CargoDTO save(CargoDTO cargoDTO) {
        Cargo cargo = CargoMapper.instance.cargoCreateDTOACargo(cargoDTO);
        return CargoMapper.instance.cargoACargoDTO(cargoRepository.save(cargo));
    }

    @Override
    public CargoDTO update(CargoDTO cargoDTO) {
        Cargo cargo = CargoMapper.instance.cargoUpdateDTOACargo(cargoDTO);
        return CargoMapper.instance.cargoACargoDTO(cargoRepository.save(cargo));
    }

    @Override
    public void delete(int id) {
        cargoRepository.deleteById(id);
    }
}
