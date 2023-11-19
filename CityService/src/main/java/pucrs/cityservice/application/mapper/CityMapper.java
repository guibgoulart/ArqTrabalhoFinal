package pucrs.cityservice.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pucrs.cityservice.domain.models.City;
import pucrs.cityservice.application.dto.CityDTO;

import java.util.List;

@Mapper
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    CityDTO cityToCityDTO(City city);
    List<CityDTO> cityListToCityDTO(List<City> cityList);

    City cityDTOToCity(CityDTO cityDTO);
    List<City> cityDTOListToCityList(List<CityDTO> cityDTOList);
}