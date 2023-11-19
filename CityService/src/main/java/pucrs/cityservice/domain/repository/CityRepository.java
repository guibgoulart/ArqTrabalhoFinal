package pucrs.cityservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pucrs.cityservice.domain.models.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findByPostalCodePrefix(String cepPrefix);
    City findByName(String name);
}

