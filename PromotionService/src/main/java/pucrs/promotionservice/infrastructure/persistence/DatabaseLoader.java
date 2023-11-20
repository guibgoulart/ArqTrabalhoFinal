package pucrs.promotionservice.infrastructure.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pucrs.promotionservice.application.clients.CityClient;
import pucrs.promotionservice.application.dto.CityDTO;
import pucrs.promotionservice.domain.models.Promotion;
import pucrs.promotionservice.domain.repository.PromotionRepository;

import java.time.LocalDate;

@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private CityClient cityClient;
    @Override
    public void run(String... strings) throws Exception {
        CityDTO cityDto = cityClient.getCityByName("Porto Alegre");
        Promotion promotion = new Promotion();

        // Set the cityName from the DTO
        promotion.setCityName(cityDto.getName());

        promotion.setDiscountPercentage(0.1);
        promotion.setDescription("Promoção de 10% para Porto Alegre");
        promotion.setStartDate(LocalDate.now());
        promotion.setEndDate(LocalDate.now().plusDays(10));

        promotionRepository.save(promotion);
    }
}