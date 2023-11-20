package pucrs.orderestimateservice.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.*;
import pucrs.orderestimateservice.application.dto.OrderEstimateDTO;
import pucrs.orderestimateservice.application.mapper.OrderEstimateMapper;
import pucrs.orderestimateservice.domain.models.OrderEstimate;
import pucrs.orderestimateservice.domain.services.OrderEstimateService;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/orders")
public class OrderEstimateController {

    @Autowired
    private OrderEstimateService orderEstimateService;

    @Autowired
    private KafkaTemplate<String, OrderEstimate> template;

    @PostMapping("/generate")
    public void generateOrderEstimate(@RequestBody OrderEstimateDTO orderEstimateDTO) {
        template.send("orders",OrderEstimateMapper.INSTANCE.orderEstimateDTOToOrderEstimate(orderEstimateDTO));
    }

    @GetMapping("/{id}")
    public OrderEstimateDTO getOrderById(@PathVariable(value = "id") Long id) {
        var orderEstimate = orderEstimateService.getOrderById(id);

        return OrderEstimateMapper.INSTANCE.orderEstimateToOrderEstimateDTO(orderEstimate);
    }

    @GetMapping("/date/{date}")
    public List<OrderEstimateDTO> getOrdersByDate(@PathVariable(value = "date") String date) {
        var orderEstimates = orderEstimateService.getOrdersByDate(LocalDate.parse(date));

        return OrderEstimateMapper.INSTANCE.orderEstimateListToOrderEstimateDTOList(orderEstimates);
    }
}
