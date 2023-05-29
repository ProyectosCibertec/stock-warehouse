package edu.cibertec.stockwarehouse.ordencompra.infrastructure.in;

import edu.cibertec.stockwarehouse.ordencompra.application.OrdenCompraService;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraCreateDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraDetalleDTO;
import edu.cibertec.stockwarehouse.ordencompra.domain.dto.OrdenCompraUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenCompra")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraService ordenCompraService;

    @GetMapping("/")
    public ResponseEntity<List<OrdenCompraDTO>> listarOrdenesCompra() {
        return new ResponseEntity<>(ordenCompraService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/ordendetalle/{id}")
    public ResponseEntity<OrdenCompraDetalleDTO> listarOrdenCompraConDetalle(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(ordenCompraService.ordenCompraConDetalle(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenCompraDTO> buscarOrdenCompraPorID(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(ordenCompraService.findByID(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<OrdenCompraDTO> registrarOrdenCompra(@RequestBody OrdenCompraCreateDTO
                                                                       ordenCompraCreateDTO) {
        return new ResponseEntity<>(ordenCompraService.save(ordenCompraCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<OrdenCompraDTO> actualizarOrdeCompra(@RequestBody OrdenCompraUpdateDTO ordenCompraUpdateDTO) {
        return new ResponseEntity<>(ordenCompraService.update(ordenCompraUpdateDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void eliminarOrdeCompra(@PathVariable(value = "id") int id) {
        ordenCompraService.delete(id);
    }
}
