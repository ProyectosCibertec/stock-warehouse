package edu.cibertec.stockwarehouse.producto.infrastructure.in;

import edu.cibertec.stockwarehouse.producto.application.ProductoService;
import edu.cibertec.stockwarehouse.producto.domain.dto.ProductoCreateDTO;
import edu.cibertec.stockwarehouse.producto.domain.dto.ProductoDTO;
import edu.cibertec.stockwarehouse.producto.domain.dto.ProductoUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("")
    public ResponseEntity<List<ProductoDTO>> listarProductos() {
        return new ResponseEntity<>(productoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> buscarProducto(@PathVariable("id") int id) {
        return new ResponseEntity<>(productoService.find(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ProductoDTO> registrarProducto(@RequestBody ProductoCreateDTO productoCreateDTO) {
        return new ResponseEntity<>(productoService.save(productoCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<ProductoDTO> actualizarProducto(@RequestBody ProductoUpdateDTO productoUpdateDTO) {
        return new ResponseEntity<>(productoService.update(productoUpdateDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable("id") int id) {
        productoService.delete(id);
    }
}


