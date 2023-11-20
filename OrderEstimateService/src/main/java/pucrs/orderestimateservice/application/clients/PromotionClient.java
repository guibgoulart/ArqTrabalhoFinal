package pucrs.orderestimateservice.application.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pucrs.orderestimateservice.application.dto.PromotionDTO;

@FeignClient(name = "promotion-service", url = "http://localhost:8081") // Adjust the port accordingly
public interface PromotionClient {
    @GetMapping("/api/promotions/{cityName}")
    PromotionDTO getActivePromotion(@PathVariable("cityName") String name);
}