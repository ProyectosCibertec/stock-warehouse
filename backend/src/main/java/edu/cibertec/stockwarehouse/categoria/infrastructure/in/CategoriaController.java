package edu.cibertec.stockwarehouse.categoria.infrastructure.in;

import edu.cibertec.stockwarehouse.categoria.aplication.CategoriaService;
import edu.cibertec.stockwarehouse.categoria.domain.dto.CategoriaCreateDTO;
import edu.cibertec.stockwarehouse.categoria.domain.dto.CategoriaDTO;
import edu.cibertec.stockwarehouse.categoria.domain.dto.CategoriaUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public ResponseEntity<List<CategoriaDTO>> listarCategorias() {
        return new ResponseEntity<>(categoriaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> buscarCategoria(@PathVariable("id") int id) {
        return new ResponseEntity<>(categoriaService.find(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<CategoriaDTO> registrarCategoria(@RequestBody CategoriaCreateDTO categoriaCreateDTO) {
        return new ResponseEntity<>(categoriaService.save(categoriaCreateDTO), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<CategoriaDTO> actualizarCategoria(@RequestBody CategoriaUpdateDTO categoriaUpdateDTO) {
        return new ResponseEntity<>(categoriaService.update(categoriaUpdateDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/id")
    public void eliminarCategoria(@PathVariable("id") int id) {
        categoriaService.delete(id);
    }
}
