package edu.cibertec.stockwarehouse.cargo.infrastructure.in;

import edu.cibertec.stockwarehouse.cargo.application.CargoService;
import edu.cibertec.stockwarehouse.cargo.domain.dto.CargoCreateDTO;
import edu.cibertec.stockwarehouse.cargo.domain.dto.CargoDTO;
import edu.cibertec.stockwarehouse.cargo.domain.dto.CargoUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargo")
public class CargoController {
    @Autowired
    private CargoService cargoService;

    @GetMapping("/")
    public ResponseEntity<List<CargoDTO>> listarCargos() {
        return new ResponseEntity<>(cargoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoDTO> obtenerCargo(@PathVariable("id") int id) {
        return new ResponseEntity<>(cargoService.find(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<CargoDTO> registrarCargo(@RequestBody CargoCreateDTO cargoCreateDTO) {
        return new ResponseEntity<>(cargoService.save(cargoCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<CargoDTO> actualizarCargo(@RequestBody CargoUpdateDTO cargoUpdateDTO) {
        return new ResponseEntity<>(cargoService.update(cargoUpdateDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void eliminarCargo(@PathVariable("id") int id) {
        cargoService.delete(id);
    }
}
