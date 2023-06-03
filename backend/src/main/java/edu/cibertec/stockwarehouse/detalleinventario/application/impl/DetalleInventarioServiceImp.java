package edu.cibertec.stockwarehouse.detalleinventario.application.impl;

import edu.cibertec.stockwarehouse.detalleinventario.application.DetalleInventarioService;
import edu.cibertec.stockwarehouse.detalleinventario.domain.dto.DetalleInventarioCreateDTO;
import edu.cibertec.stockwarehouse.detalleinventario.domain.dto.DetalleInventarioDTO;
import edu.cibertec.stockwarehouse.detalleinventario.domain.dto.DetalleInventarioUpdateDTO;
import edu.cibertec.stockwarehouse.detalleinventario.domain.mapper.DetalleInventarioMapper;
import edu.cibertec.stockwarehouse.detalleinventario.domain.model.DetalleInventario;
import edu.cibertec.stockwarehouse.detalleinventario.infrastructure.out.DetalleInventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleInventarioServiceImp implements DetalleInventarioService {

    @Autowired
    private DetalleInventarioRepository detalleInventarioRepository;

    @Override
    public List<DetalleInventarioDTO> findAll() {
        return DetalleInventarioMapper.instancia.listaDetalleInventarioADetalleInventarioDTO(detalleInventarioRepository.findAll());
    }

    @Override
    public DetalleInventarioDTO findByID(int id) {
        Optional<DetalleInventario> detalleInventarioOptional = detalleInventarioRepository.findById(id);
        if (detalleInventarioOptional.isPresent()) {
            return DetalleInventarioMapper.instancia.detalleInvantarioDetalleInventarioDTO(detalleInventarioOptional.get());
        } else {
            throw new NoResultException("No se encontro el detalle con id: " + id);
        }
    }

    @Override
    public DetalleInventarioDTO save(DetalleInventarioCreateDTO detalleInventarioCreateDTO) {
        DetalleInventario detalleInventario = DetalleInventarioMapper.instancia
                .detalleInventarioCreateDTOADetalleInventario(detalleInventarioCreateDTO);

        return DetalleInventarioMapper.instancia.detalleInvantarioDetalleInventarioDTO(detalleInventarioRepository.save(detalleInventario));
    }

    @Override
    public DetalleInventarioDTO update(DetalleInventarioUpdateDTO detalleInventarioUpdateDTO) {

        DetalleInventario detalleInventario = DetalleInventarioMapper.instancia
                .detalleInventarioUpdateDTOADetalleInventario(detalleInventarioUpdateDTO);

        return DetalleInventarioMapper.instancia.detalleInvantarioDetalleInventarioDTO(detalleInventarioRepository.save(detalleInventario));
    }

    @Override
    public void delete(int id) {
        Optional<DetalleInventario> detalleInventarioOptional = detalleInventarioRepository.findById(id);

        if (detalleInventarioOptional.isPresent()) {
            detalleInventarioRepository.delete(detalleInventarioOptional.get());
        } else {
            throw new NoResultException("No se encontro el Detalle de inventario con id: " + id);
        }

    }
}
