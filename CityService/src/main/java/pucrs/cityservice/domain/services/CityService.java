package pucrs.cityservice.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pucrs.cityservice.domain.models.City;
import pucrs.cityservice.domain.repository.CityRepository;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public boolean checkIfCityIsAvailable(String postalCode) {
        var city = cityRepository.findByPostalCodePrefix(postalCode);
        return city != null;
    }

    public City getCityByName(String cityName) {
        return cityRepository.findByName(cityName);
    }
}