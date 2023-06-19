package edu.cibertec.stockwarehouse.usuario.infrastructure.in;

import edu.cibertec.stockwarehouse.usuario.application.UsuarioService;
import edu.cibertec.stockwarehouse.usuario.domain.dto.UsuarioCreateDto;
import edu.cibertec.stockwarehouse.usuario.domain.dto.UsuarioDto;
import edu.cibertec.stockwarehouse.usuario.domain.dto.UsuarioUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("usuario")
    public ResponseEntity<List<UsuarioDto>> listarUsuarios(){
        return new ResponseEntity<>(usuarioService.listarUsuarios(), HttpStatus.OK);
    }

    @GetMapping("usuario/{id_usuario}")
    public ResponseEntity<UsuarioDto> obtenerUsuarioPorId(@PathVariable("id_usuario") long id_usuario){
        return new ResponseEntity<>(usuarioService.obtenerUsuarioPorId(id_usuario), HttpStatus.OK);
    }

    @PostMapping("usuario")
    public ResponseEntity<UsuarioDto> registrarUsuario (@RequestBody UsuarioCreateDto usuarioCreateDto){
        return new ResponseEntity<>(usuarioService.registrarProducto(usuarioCreateDto), HttpStatus.OK);
    }

    @PutMapping("usuario")
    public ResponseEntity<UsuarioDto> actualizarUsuario (@RequestBody UsuarioUpdateDto usuarioUpdateDto){
        return new ResponseEntity<>(usuarioService.actualizarProducto(usuarioUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("usuario/{id_usuario}")
    public ResponseEntity<Void> eliminarOrdeCompra(@PathVariable(value = "id_usuario") long id_usuario) {
        usuarioService.eliminarUsuario(id_usuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
