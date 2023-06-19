package edu.cibertec.stockwarehouse.tipousuario.infrastructure.in;

import edu.cibertec.stockwarehouse.tipousuario.application.TipoUsuarioService;
import edu.cibertec.stockwarehouse.tipousuario.domain.dto.TipoUsuarioCreateDto;
import edu.cibertec.stockwarehouse.tipousuario.domain.dto.TipoUsuarioDto;
import edu.cibertec.stockwarehouse.tipousuario.domain.dto.TipoUsuarioUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TipoUsuarioController {
    private final TipoUsuarioService tipoUsuarioService;

    public TipoUsuarioController(TipoUsuarioService tipoUsuarioService) {
        this.tipoUsuarioService = tipoUsuarioService;
    }

    @GetMapping("tipo-usuario")
    public ResponseEntity<List<TipoUsuarioDto>> listarTipoUsuarios() {
        return new ResponseEntity<>(tipoUsuarioService.listarTipoUsuarios(), HttpStatus.OK);
    }

    @GetMapping("tipo-usuario/{idTipoUsuario}")
    public ResponseEntity<TipoUsuarioDto> obtenerTipoUsuarioPorId(@PathVariable("idTipoUsuario") long idTipoUsuario) {
        return new ResponseEntity<>(tipoUsuarioService.obtenerTipoUsuarioPorId(idTipoUsuario), HttpStatus.OK);
    }

    @PostMapping("tipo-usuario")
    public ResponseEntity<TipoUsuarioDto> registrarUsuario(@RequestBody TipoUsuarioCreateDto tipoUsuarioCreateDto) {
        return new ResponseEntity<>(tipoUsuarioService.registrarTipoUsuario(tipoUsuarioCreateDto), HttpStatus.OK);
    }

    @PutMapping("tipo-usuario")
    public ResponseEntity<TipoUsuarioDto> actualizarUsuario(@RequestBody TipoUsuarioUpdateDto tipoUsuarioUpdateDto) {
        return new ResponseEntity<>(tipoUsuarioService.actualizarTipoUsuario(tipoUsuarioUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("tipo-usuario/{idTipoUsuario}")
    public ResponseEntity<Void> eliminarOrdeCompra(@PathVariable("idTipoUsuario") long idTipoUsuario) {
        tipoUsuarioService.eliminarTipoUsuario(idTipoUsuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
