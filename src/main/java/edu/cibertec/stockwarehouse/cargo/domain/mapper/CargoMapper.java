package edu.cibertec.stockwarehouse.cargo.domain.mapper;

import edu.cibertec.stockwarehouse.cargo.domain.dto.CargoCreateDTO;
import edu.cibertec.stockwarehouse.cargo.domain.dto.CargoDTO;
import edu.cibertec.stockwarehouse.cargo.domain.dto.CargoUpdateDTO;
import edu.cibertec.stockwarehouse.cargo.domain.model.Cargo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CargoMapper {

    CargoMapper instance = Mappers.getMapper(CargoMapper.class);

    CargoDTO cargoACargoDTO(Cargo cargo);

    Cargo cargoDTOACargo(CargoDTO cargoDTO);

    Cargo cargoUpdateDTOACargo(CargoUpdateDTO cargoUpdateDTO);

    Cargo cargoCreateDTOACargo(CargoCreateDTO cargoCreateDTO);

    List<CargoDTO> listaCargoAListaCargoDTO(List<Cargo> cargoList);
}
