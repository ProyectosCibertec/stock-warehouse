package edu.cibertec.stockwarehouse.proveedor.infrastructure.in;

import edu.cibertec.stockwarehouse.proveedor.application.ProveedorService;
import edu.cibertec.stockwarehouse.proveedor.domain.dto.ProveedorCreateDTO;
import edu.cibertec.stockwarehouse.proveedor.domain.dto.ProveedorDTO;
import edu.cibertec.stockwarehouse.proveedor.domain.dto.ProveedorUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {
    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping("")
    public ResponseEntity<List<ProveedorDTO>> listarProveedores() {
        return new ResponseEntity<>(proveedorService.listarProveedores(), HttpStatus.OK);
    }

    @GetMapping("/{proveedorId}")
    public ResponseEntity<ProveedorDTO> obtenerProveedorPorId(@PathVariable("proveedorId") long proveedorId) {
        return new ResponseEntity<>(proveedorService.obtenerProveedorPorID(proveedorId), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ProveedorDTO> registrarProveedor(@RequestBody ProveedorCreateDTO proveedorCreateDTO) {
        return new ResponseEntity<>(proveedorService.registrarProveedor(proveedorCreateDTO), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<ProveedorDTO> actualizarProveedor(@RequestBody ProveedorUpdateDTO proveedorUpdateDTO) {
        return new ResponseEntity<>(proveedorService.actualizarProveedor(proveedorUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{proveedorId}")
    public void eliminarProveedor(@PathVariable("proveedorId") long id) {
        proveedorService.delete(id);
    }
}
