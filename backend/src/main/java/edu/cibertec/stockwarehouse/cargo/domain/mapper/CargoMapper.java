package edu.cibertec.stockwarehouse.cargo.domain.mapper;

import edu.cibertec.stockwarehouse.cargo.domain.dto.CargoDTO;
import edu.cibertec.stockwarehouse.cargo.domain.model.Cargo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CargoMapper {

    CargoMapper instance = Mappers.getMapper(CargoMapper.class);

    CargoDTO cargoACargoDTO(Cargo cargo);

    Cargo cargoDTOACargo(CargoDTO cargoDTO);

    Cargo cargoUpdateDTOACargo(CargoDTO cargoDTO);

    Cargo cargoCreateDTOACargo(CargoDTO cargoDTO);

    List<CargoDTO> listaCargoAListaCargoDTO(List<Cargo> cargoList);
}
