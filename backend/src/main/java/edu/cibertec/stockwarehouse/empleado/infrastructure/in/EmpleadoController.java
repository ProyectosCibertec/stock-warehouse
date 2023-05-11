package edu.cibertec.stockwarehouse.empleado.infrastructure.in;

import edu.cibertec.stockwarehouse.empleado.application.EmpleadoService;
import edu.cibertec.stockwarehouse.empleado.domain.dto.EmpleadoCreateDTO;
import edu.cibertec.stockwarehouse.empleado.domain.dto.EmpleadoDTO;
import edu.cibertec.stockwarehouse.empleado.domain.dto.EmpleadoUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/")
    public ResponseEntity<List<EmpleadoDTO>> listarEmpleados() {
        return new ResponseEntity<>(empleadoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> obtenerEmpleado(@PathVariable("id") int id) {
        return new ResponseEntity<>(empleadoService.find(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<EmpleadoDTO> registrarEmpleado(@RequestBody EmpleadoCreateDTO empleadoCreateDTO) {
        return new ResponseEntity<>(empleadoService.save(empleadoCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<EmpleadoDTO> actualizarEmpleado(@RequestBody EmpleadoUpdateDTO empleadoUpdateDTO) {
        return new ResponseEntity<>(empleadoService.update(empleadoUpdateDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void eliminarEmpleado(@PathVariable("id") int id) {
        empleadoService.delete(id);
    }
}
