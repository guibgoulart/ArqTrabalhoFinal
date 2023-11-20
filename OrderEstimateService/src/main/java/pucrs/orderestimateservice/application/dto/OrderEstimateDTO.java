package pucrs.orderestimateservice.application.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderEstimateDTO {
    private String originCity;
    private String destinationCity;
    private Integer weightInGrams;
    private BigDecimal discount;
}