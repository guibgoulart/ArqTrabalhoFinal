package pucrs.promotionservice.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pucrs.promotionservice.application.dto.PromotionDTO;
import pucrs.promotionservice.application.mapper.PromotionMapper;
import pucrs.promotionservice.domain.models.Promotion;
import pucrs.promotionservice.domain.services.PromotionService;

import java.util.List;

@RestController
@RequestMapping("/api/promotions")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @GetMapping
    public List<PromotionDTO> getAllPromotions() {
        List<Promotion> promotions = promotionService.getAllPromotions();

        return PromotionMapper.INSTANCE.promotionListToPromotionDTO(promotions);
    }

    @GetMapping("/{cityName}")
    public PromotionDTO getActivePromotion(@PathVariable(value = "cityName") String cityName) {
        Promotion promotion = promotionService.getActivePromotion(cityName);

        return PromotionMapper.INSTANCE.promotionToPromotionDTO(promotion);
    }
}