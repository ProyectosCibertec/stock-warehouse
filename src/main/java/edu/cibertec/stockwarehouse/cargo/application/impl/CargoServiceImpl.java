package edu.cibertec.stockwarehouse.cargo.application.impl;

import edu.cibertec.stockwarehouse.cargo.application.service.CargoService;
import edu.cibertec.stockwarehouse.cargo.domain.Cargo;
import edu.cibertec.stockwarehouse.cargo.infrastructure.out.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoServiceImpl implements CargoService {
    @Autowired
    private CargoRepository cargoRepository;


    @Override
    public Cargo find(int id) {
        Optional<Cargo> pivot = cargoRepository.findById(id);
        if (pivot.isPresent()) {
            return pivot.get();
        }
        throw new RuntimeException();
    }

    @Override
    public List<Cargo> findAll() {
        return cargoRepository.findAll();
    }

    @Override
    public Cargo save(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public void delete(int id) {
        cargoRepository.deleteById(id);
    }
}
