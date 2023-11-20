package pucrs.orderestimateservice.domain.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "order_estimates")
public class OrderEstimate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateProvided;
    private String originCity;
    private String destinationCity;
    private Integer weightInGrams;
    private BigDecimal basicCost;
    private BigDecimal additionalCost;
    private BigDecimal taxValue;
    private BigDecimal discount;
    private BigDecimal finalValue;
}