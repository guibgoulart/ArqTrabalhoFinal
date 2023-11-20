package pucrs.orderestimateservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pucrs.orderestimateservice.domain.models.OrderEstimate;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderEstimateRepository extends JpaRepository<OrderEstimate, Long> {
    List<OrderEstimate> findByDateProvided(LocalDate dateProvided);
}
