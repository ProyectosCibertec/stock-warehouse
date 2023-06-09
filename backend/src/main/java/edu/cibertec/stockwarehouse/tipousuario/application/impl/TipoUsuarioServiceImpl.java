package edu.cibertec.stockwarehouse.tipousuario.application.impl;

import edu.cibertec.stockwarehouse.tipousuario.application.TipoUsuarioService;
import edu.cibertec.stockwarehouse.tipousuario.domain.dto.TipoUsuarioCreateDto;
import edu.cibertec.stockwarehouse.tipousuario.domain.dto.TipoUsuarioDto;
import edu.cibertec.stockwarehouse.tipousuario.domain.dto.TipoUsuarioUpdateDto;
import edu.cibertec.stockwarehouse.tipousuario.domain.mapper.TipoUsuarioMapper;
import edu.cibertec.stockwarehouse.tipousuario.domain.model.TipoUsuario;
import edu.cibertec.stockwarehouse.tipousuario.infrastructure.out.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService {
    private final TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioServiceImpl(TipoUsuarioRepository tipoUsuarioRepository) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    @Override
    public List<TipoUsuarioDto> listarTipoUsuarios() {
        return TipoUsuarioMapper.INSTANCE.listaTipoUsuarioAListaTipoUsuarioDto(tipoUsuarioRepository.findAll());

    }

    @Override
    public TipoUsuarioDto obtenerTipoUsuarioPorId(long id) {
        Optional<TipoUsuario> tipoUsuario = tipoUsuarioRepository.findById(id);
        TipoUsuarioDto tipoUsuarioDto;
        if (tipoUsuario.isPresent()) {
            tipoUsuarioDto = TipoUsuarioMapper.INSTANCE.tipoUsuarioATipoUsuarioDto(tipoUsuario.get());
        } else {
            tipoUsuarioDto = null;
        }
        return tipoUsuarioDto;
    }

    @Override
    public TipoUsuarioDto registrarTipoUsuario(TipoUsuarioCreateDto tipoUsuarioCreateDto) {
        TipoUsuario tipoUsuario = TipoUsuarioMapper.INSTANCE.tipoUsuarioCreateDtoATipoUsuario(tipoUsuarioCreateDto);
        TipoUsuario respuestaEntity = tipoUsuarioRepository.save(tipoUsuario);
        TipoUsuarioDto respuestDto = TipoUsuarioMapper.INSTANCE.tipoUsuarioATipoUsuarioDto(respuestaEntity);
        return respuestDto;
    }

    @Override
    public TipoUsuarioDto actualizarTipoUsuario(TipoUsuarioUpdateDto tipoUsuarioUpdateDto) {
        TipoUsuario tipoUsuario = TipoUsuarioMapper.INSTANCE.tipoUsuarioUpdateDtoATipoUsuario(tipoUsuarioUpdateDto);
        TipoUsuario respuestaEntity = tipoUsuarioRepository.save(tipoUsuario);
        TipoUsuarioDto respuestDto = TipoUsuarioMapper.INSTANCE.tipoUsuarioATipoUsuarioDto(respuestaEntity);
        return respuestDto;
    }

    @Override
    public String eliminarTipoUsuario(long id) {
        Optional<TipoUsuario> entities = tipoUsuarioRepository.findById(id);
        String resultado;
        if (entities.isPresent()) {
            tipoUsuarioRepository.deleteById(id);
            resultado = "Registro Eliminado";
        } else {
            resultado = "No se pudo realizar la eliminación";
        }
        return resultado;
    }

}
