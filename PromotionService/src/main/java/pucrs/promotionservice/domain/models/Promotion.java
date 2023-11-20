package pucrs.promotionservice.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "promotions")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cityName; // Stores the ID of the city

    private double discountPercentage;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public Promotion(String cityName, double discountPercentage, String description, LocalDate startDate, LocalDate endDate) {
        this.cityName = cityName;
        this.discountPercentage = discountPercentage;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}