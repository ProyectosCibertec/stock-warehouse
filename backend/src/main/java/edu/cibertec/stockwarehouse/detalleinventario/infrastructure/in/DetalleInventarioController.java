package edu.cibertec.stockwarehouse.detalleinventario.infrastructure.in;

import edu.cibertec.stockwarehouse.detalleinventario.application.DetalleInventarioService;
import edu.cibertec.stockwarehouse.detalleinventario.domain.dto.DetalleInventarioCreateDTO;
import edu.cibertec.stockwarehouse.detalleinventario.domain.dto.DetalleInventarioDTO;
import edu.cibertec.stockwarehouse.detalleinventario.domain.dto.DetalleInventarioUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalleInventario")
public class DetalleInventarioController {
    private final DetalleInventarioService detalleInventarioService;

    public DetalleInventarioController(DetalleInventarioService detalleInventarioService) {
        this.detalleInventarioService = detalleInventarioService;
    }

    @GetMapping("")
    public ResponseEntity<List<DetalleInventarioDTO>> listarDetallesInventario() {
        return new ResponseEntity<>(detalleInventarioService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleInventarioDTO> buscarDetalleInventarioPorID(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(detalleInventarioService.findByID(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<DetalleInventarioDTO> registrarDetalleInventario(@RequestBody DetalleInventarioCreateDTO
                                                                                   detalleInventarioCreateDTO) {
        return new ResponseEntity<>(detalleInventarioService.save(detalleInventarioCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<DetalleInventarioDTO> actualizarDetalleInventario(@RequestBody DetalleInventarioUpdateDTO detalleInventarioUpdateDTO) {
        return new ResponseEntity<>(detalleInventarioService.update(detalleInventarioUpdateDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void eliminarDetalleInventario(@PathVariable(value = "id") int id) {
        detalleInventarioService.delete(id);
    }

}
