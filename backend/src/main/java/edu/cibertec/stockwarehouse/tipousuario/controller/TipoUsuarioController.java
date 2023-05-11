package edu.cibertec.stockwarehouse.tipousuario.controller;

import edu.cibertec.stockwarehouse.tipousuario.dtos.TipoUsuarioCreateDto;
import edu.cibertec.stockwarehouse.tipousuario.dtos.TipoUsuarioDto;
import edu.cibertec.stockwarehouse.tipousuario.dtos.TipoUsuarioUpdateDto;
import edu.cibertec.stockwarehouse.tipousuario.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @GetMapping("tipo-usuario")
    public ResponseEntity<List<TipoUsuarioDto>> listarTipoUsuarios(){
        return new ResponseEntity<>(tipoUsuarioService.listarTipoUsuarios(), HttpStatus.OK);
    }

    @GetMapping("tipo-usuario/{idTipoUsuario}")
    public ResponseEntity<TipoUsuarioDto> obtenerTipoUsuarioPorId(@PathVariable("idTipoUsuario") long idTipoUsuario){
        return new ResponseEntity<>(tipoUsuarioService.obtenerTipoUsuarioPorId(idTipoUsuario), HttpStatus.OK);
    }

    @PostMapping("tipo-usuario")
    public ResponseEntity<TipoUsuarioDto> registrarUsuario (@RequestBody TipoUsuarioCreateDto tipoUsuarioCreateDto){
        return new ResponseEntity<>(tipoUsuarioService.registrarTipoUsuario(tipoUsuarioCreateDto), HttpStatus.OK);
    }

    @PutMapping("tipo-usuario")
    public ResponseEntity<TipoUsuarioDto> actualizarUsuario (@RequestBody TipoUsuarioUpdateDto tipoUsuarioUpdateDto){
        return new ResponseEntity<>(tipoUsuarioService.actualizarTipoUsuario(tipoUsuarioUpdateDto), HttpStatus.OK);
    }
    @DeleteMapping("tipo-usuario/{idTipoUsuario}")
    public ResponseEntity eliminarOrdeCompra(@PathVariable("idTipoUsuario") long idTipoUsuario){
        return new ResponseEntity<>(tipoUsuarioService.eliminarTipoUsuario(idTipoUsuario), HttpStatus.OK);
    }
}
