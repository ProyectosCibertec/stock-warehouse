package edu.cibertec.stockwarehouse.cargo.infrastructure.in;

import edu.cibertec.stockwarehouse.cargo.application.CargoService;
import edu.cibertec.stockwarehouse.cargo.domain.dto.CargoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargo")
@CrossOrigin(origins = "http://localhost:4200")
public class CargoController {
    @Autowired
    private CargoService cargoService;

    @GetMapping("")
    public ResponseEntity<List<CargoDTO>> listarCargos() {
        return new ResponseEntity<>(cargoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoDTO> obtenerCargo(@PathVariable("id") int id) {
        return new ResponseEntity<>(cargoService.find(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<CargoDTO> registrarCargo(@RequestBody CargoDTO cargoDTO) {
        return new ResponseEntity<>(cargoService.save(cargoDTO), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<CargoDTO> actualizarCargo(@RequestBody CargoDTO cargoDTO) {
        return new ResponseEntity<>(cargoService.update(cargoDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void eliminarCargo(@PathVariable("id") int id) {
        cargoService.delete(id);
    }
}
