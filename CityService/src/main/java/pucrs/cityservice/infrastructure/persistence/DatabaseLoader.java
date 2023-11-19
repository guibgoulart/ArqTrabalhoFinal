package pucrs.cityservice.infrastructure.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pucrs.cityservice.domain.models.City;
import pucrs.cityservice.domain.repository.CityRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public void run(String... strings) throws Exception {
        cityRepository.save(new City("Porto Alegre", "POA_CEP_PREFIX", 25.00, 5.0));
        cityRepository.save(new City("Florianópolis", "FLN_CEP_PREFIX", 20.00, 5.0));
        cityRepository.save(new City("Curitiba", "CUR_CEP_PREFIX", 15.00, 5.0));
        cityRepository.save(new City("São Paulo", "SPO_CEP_PREFIX", 10.00, 5.0));
    }
}