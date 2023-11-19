package pucrs.cityservice.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pucrs.cityservice.application.dto.CityDTO;
import pucrs.cityservice.application.mapper.CityMapper;
import pucrs.cityservice.domain.models.City;
import pucrs.cityservice.domain.services.CityService;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<CityDTO> getAllCities() {
        List<City> cities = cityService.getAllCities();

        return CityMapper.INSTANCE.cityListToCityDTO(cities);
    }

    @GetMapping("/{postalCode}")
    public boolean checkIfCityIsAvailable(@PathVariable(value="postalCode") String postalCode) {
        return cityService.checkIfCityIsAvailable(postalCode);
    }
}