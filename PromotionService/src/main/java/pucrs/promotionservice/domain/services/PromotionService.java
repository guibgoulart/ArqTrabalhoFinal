package pucrs.promotionservice.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pucrs.promotionservice.domain.models.Promotion;
import pucrs.promotionservice.domain.repository.PromotionRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    public Promotion getActivePromotion(String cityName) {
        var activePromotion = promotionRepository.findByEndDateGreaterThan(LocalDate.now()).stream().filter(item -> item.getCityName().equals(cityName)).findFirst();
        return activePromotion.orElse(null);
    }
}