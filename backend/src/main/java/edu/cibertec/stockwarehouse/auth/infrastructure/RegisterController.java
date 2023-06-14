package edu.cibertec.stockwarehouse.auth.infrastructure;

import edu.cibertec.stockwarehouse.usuario.application.UsuarioService;
import edu.cibertec.stockwarehouse.usuario.domain.dto.UsuarioCreateDto;
import edu.cibertec.stockwarehouse.usuario.domain.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin
public class RegisterController {
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<UsuarioDto> register(UsuarioCreateDto usuarioCreateDto) {
        return new ResponseEntity<>(usuarioService.registrarProducto(usuarioCreateDto), HttpStatus.CREATED);
    }
}
