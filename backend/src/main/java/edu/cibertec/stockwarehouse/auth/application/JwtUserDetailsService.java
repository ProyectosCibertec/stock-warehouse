package edu.cibertec.stockwarehouse.auth.application;

import edu.cibertec.stockwarehouse.auth.domain.MyUsuarioPrincipal;
import edu.cibertec.stockwarehouse.usuario.domain.model.Usuario;
import edu.cibertec.stockwarehouse.usuario.infrastructure.out.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    public JwtUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLoginUsuario(username);
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUsuarioPrincipal(usuario);
    }
}