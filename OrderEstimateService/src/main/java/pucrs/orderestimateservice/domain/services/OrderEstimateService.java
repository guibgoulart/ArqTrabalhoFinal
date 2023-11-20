package pucrs.orderestimateservice.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pucrs.orderestimateservice.application.clients.CityClient;
import pucrs.orderestimateservice.application.clients.PromotionClient;
import pucrs.orderestimateservice.application.dto.CityDTO;
import pucrs.orderestimateservice.domain.models.OrderEstimate;
import pucrs.orderestimateservice.domain.repository.OrderEstimateRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

import static java.math.BigDecimal.valueOf;

@Service
public class OrderEstimateService {

    @Autowired
    private OrderEstimateRepository orderEstimateRepository;

    @Autowired
    private CityClient cityClient;

    @Autowired
    private PromotionClient promotionClient;

    @KafkaListener(topics = "orders")
    private void listen(OrderEstimate input) {
        generateOrderEstimate(input);
    }

    public OrderEstimate generateOrderEstimate(OrderEstimate orderEstimate) {
        calculateFinalValue(orderEstimate);
        orderEstimate.setDateProvided(LocalDate.now());
        return orderEstimateRepository.save(orderEstimate);
    }

    public OrderEstimate getOrderById(Long id) {
        return orderEstimateRepository.findById(id).orElse(null);
    }

    public List<OrderEstimate> getOrdersByDate(LocalDate dateProvided) {
        return orderEstimateRepository.findByDateProvided(dateProvided);
    }

    private BigDecimal toKilograms(OrderEstimate orderEstimate) {
        return valueOf(orderEstimate.getWeightInGrams()).divide(valueOf(1000), RoundingMode.HALF_UP);
    }

    private BigDecimal calculateAdditionalCost(OrderEstimate orderEstimate) {
        BigDecimal weightInKilograms = toKilograms(orderEstimate);
        if (weightInKilograms.compareTo(valueOf(5)) <= 0) {
            return BigDecimal.ZERO;
        } else if (weightInKilograms.compareTo(valueOf(5)) >= 0 && weightInKilograms.compareTo(valueOf(20)) <= 0) {
            return valueOf(10).multiply(weightInKilograms);
        } else {
            return valueOf(10)
                    .multiply(weightInKilograms)
                    .add(weightInKilograms.divide(valueOf(5)).multiply(valueOf(20)));
        }
    }

    private void calculateFinalValue(OrderEstimate orderEstimate) {
        BigDecimal additionalCost = calculateAdditionalCost(orderEstimate);
        BigDecimal distanceCost = calculateCostTransport(orderEstimate);
        orderEstimate.setFinalValue(additionalCost.add(distanceCost)
                .multiply(valueOf(promotionClient.getActivePromotion(orderEstimate.getDestinationCity()).getDiscountPercentage())));
    }

    public BigDecimal calculateCostTransport(OrderEstimate orderEstimate) {
        CityDTO origin = cityClient.getCityByName(orderEstimate.getOriginCity());
        CityDTO destination = cityClient.getCityByName(orderEstimate.getDestinationCity());
        return valueOf(origin.getBasicCostToSaoPaulo()).multiply(valueOf(1.05))
                .add(valueOf(destination.getBasicCostToSaoPaulo()).multiply(valueOf(1.05)));
    }
}