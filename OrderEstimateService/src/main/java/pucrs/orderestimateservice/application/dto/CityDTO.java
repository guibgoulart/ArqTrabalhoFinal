package pucrs.orderestimateservice.application.dto;

import lombok.Data;

@Data
public class CityDTO {
    private String name;
    private String postalCodePrefix;
    private double basicCostToSaoPaulo;
    private double taxPercentage; // Representing tax as a percentage.
}