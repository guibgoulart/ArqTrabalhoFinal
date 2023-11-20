package pucrs.promotionservice.application.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PromotionDTO {
    private String cityName;
    private double discountPercentage;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}