package pucrs.cityservice.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String postalCodePrefix;
    private double basicCostToSaoPaulo;

    @Column(nullable = false)
    private double taxPercentage = 5.00;

    public City(String name, String postalCodePrefix, double basicCostToSaoPaulo, double taxPercentage) {
        this.name = name;
        this.postalCodePrefix = postalCodePrefix;
        this.basicCostToSaoPaulo = basicCostToSaoPaulo;
        this.taxPercentage = taxPercentage;
    }
}