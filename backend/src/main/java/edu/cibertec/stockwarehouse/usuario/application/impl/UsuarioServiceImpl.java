package edu.cibertec.stockwarehouse.usuario.application.impl;

import edu.cibertec.stockwarehouse.empleado.domain.model.Empleado;
import edu.cibertec.stockwarehouse.empleado.infrastructure.out.EmpleadoRepository;
import edu.cibertec.stockwarehouse.tipousuario.infrastructure.out.TipoUsuarioRepository;
import edu.cibertec.stockwarehouse.usuario.application.UsuarioService;
import edu.cibertec.stockwarehouse.usuario.domain.dto.UsuarioCreateDto;
import edu.cibertec.stockwarehouse.usuario.domain.dto.UsuarioDto;
import edu.cibertec.stockwarehouse.usuario.domain.dto.UsuarioUpdateDto;
import edu.cibertec.stockwarehouse.usuario.domain.mapper.UsuarioMapper;
import edu.cibertec.stockwarehouse.usuario.domain.model.Usuario;
import edu.cibertec.stockwarehouse.usuario.infrastructure.out.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;


    @Override
    public List<UsuarioDto> listarUsuarios() {
        return UsuarioMapper.INSTANCE.listaUsuarioAListaUsuarioDto(usuarioRepository.findAll());
    }

    @Override
    public UsuarioDto obtenerUsuarioPorId(long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        UsuarioDto usuarioDto;
        if (usuario.isPresent()) {
            usuarioDto = UsuarioMapper.INSTANCE.usuarioAUsuarioDto(usuario.get());
        } else {
            usuarioDto = null;
        }
        return usuarioDto;
    }

    @Override
    public UsuarioDto registrarProducto(UsuarioCreateDto usuarioCreateDto) {
        Usuario usuario = UsuarioMapper.INSTANCE.usaurioCreateDtoAUsuario(usuarioCreateDto);
        return getUsuarioDto(usuario);
    }

    @Override
    public UsuarioDto actualizarProducto(UsuarioUpdateDto usuarioUpdateDto) {
        Usuario usuario = UsuarioMapper.INSTANCE.usaurioUpdateDtoAUsuario(usuarioUpdateDto);
        return getUsuarioDto(usuario);
    }

    private UsuarioDto getUsuarioDto(Usuario usuario) {
        Usuario respuestaEntity = usuarioRepository.save(usuario);
        UsuarioDto respuestDto = UsuarioMapper.INSTANCE.usuarioAUsuarioDto(respuestaEntity);
        respuestDto.setNombreTipoUsuario((tipoUsuarioRepository.findById(respuestaEntity.getTipoUsuario().getIdTipoUsuario()).get().getNombreTipoUsuario()));
        Optional<Empleado> empleado = empleadoRepository.findById(respuestaEntity.getEmpleado().getId());
        respuestDto.setNombreCompletoEmpleado(empleado.get().getNombre() + ' ' + empleado.get().getApellido());
        return respuestDto;
    }

    @Override
    public String eliminarUsuario(long id) {
        Optional<Usuario> entities = usuarioRepository.findById(id);
        String resultado;
        if (entities.isPresent()) {
            usuarioRepository.deleteById(id);
            resultado = "Registro Eliminado";
        } else {
            resultado = "No se pudo realizar la eliminación";
        }
        return resultado;
    }
}
