package pucrs.orderestimateservice.application.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pucrs.orderestimateservice.application.dto.CityDTO;

@FeignClient(name = "city-service", url = "http://localhost:8080") // Adjust the port accordingly
public interface CityClient {
    @GetMapping("/api/cities/name/{name}")
    CityDTO getCityByName(@PathVariable("name") String name);
}