package edu.cibertec.stockwarehouse.detalleordencompra.infrastructure.in;

import edu.cibertec.stockwarehouse.detalleordencompra.application.service.DetalleOrdenCompraService;
import edu.cibertec.stockwarehouse.detalleordencompra.domain.dto.DetalleOrdenCompraCreateDTO;
import edu.cibertec.stockwarehouse.detalleordencompra.domain.dto.DetalleOrdenCompraDTO;
import edu.cibertec.stockwarehouse.detalleordencompra.domain.dto.DetalleOrdenCompraUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detallesOrdenCompra")
public class DetalleOrdenCompraController {

    @Autowired
    private DetalleOrdenCompraService detalleOrdenCompraService;

    @GetMapping("/")
    public ResponseEntity<List<DetalleOrdenCompraDTO>> listarOrdenesCompra(){
        return new ResponseEntity<>(detalleOrdenCompraService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleOrdenCompraDTO> buscarDetalleOrdenCompraPorID(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(detalleOrdenCompraService.findByID(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<DetalleOrdenCompraDTO> registrarDetalleOrdenCompra(@RequestBody DetalleOrdenCompraCreateDTO
                                                                       detalleOrdenCompraCreateDTO){
        return new ResponseEntity<>(detalleOrdenCompraService.save(detalleOrdenCompraCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<DetalleOrdenCompraDTO> actualizarDetalleOrdeCompra(@RequestBody DetalleOrdenCompraUpdateDTO detalleOrdenCompraUpdateDTO){
        return new ResponseEntity<>(detalleOrdenCompraService.update(detalleOrdenCompraUpdateDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public  void  eliminarDetalleOrdeCompra(@PathVariable(value = "id") int id){
        detalleOrdenCompraService.delete(id);
    }
}
