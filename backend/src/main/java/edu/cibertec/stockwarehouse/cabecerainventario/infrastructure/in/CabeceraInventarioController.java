package edu.cibertec.stockwarehouse.cabecerainventario.infrastructure.in;


import edu.cibertec.stockwarehouse.cabecerainventario.application.service.CabeceraInventarioService;
import edu.cibertec.stockwarehouse.cabecerainventario.domain.dto.CabeceraInventarioCreateDTO;
import edu.cibertec.stockwarehouse.cabecerainventario.domain.dto.CabeceraInventarioDTO;
import edu.cibertec.stockwarehouse.cabecerainventario.domain.dto.CabeceraInventarioUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cabeceraInventario")
public class CabeceraInventarioController {

    @Autowired
    private CabeceraInventarioService cabeceraInventarioService;

    @GetMapping("/")
    public ResponseEntity<List<CabeceraInventarioDTO>> listarCabeceraInventario(){
        return new ResponseEntity<>(cabeceraInventarioService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CabeceraInventarioDTO> buscarCabeceraInventarioPorID(@PathVariable(value="id") int id){
        return new ResponseEntity<>(cabeceraInventarioService.findByID(id),HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<CabeceraInventarioDTO> registrarCabeceraInventario(@RequestBody CabeceraInventarioCreateDTO cabeceraInventarioCreateDTO){
        return new ResponseEntity<>(cabeceraInventarioService.save(cabeceraInventarioCreateDTO),HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<CabeceraInventarioDTO> actualizarCabeceraInventario(@RequestBody CabeceraInventarioUpdateDTO cabeceraInventarioUpdateDTO){
        return  new ResponseEntity<>(cabeceraInventarioService.update(cabeceraInventarioUpdateDTO),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void eliminarCabeceraInventario(@PathVariable(value = "id") int id){
        cabeceraInventarioService.delete(id);
    }
}
