package pucrs.orderestimateservice.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pucrs.orderestimateservice.application.dto.OrderEstimateDTO;
import pucrs.orderestimateservice.application.mapper.OrderEstimateMapper;
import pucrs.orderestimateservice.domain.services.OrderEstimateService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderEstimateController {

    @Autowired
    private OrderEstimateService orderEstimateService;

    @PostMapping("/generate")
    public OrderEstimateDTO generateOrderEstimate(@RequestBody OrderEstimateDTO orderEstimateDTO) {
        var orderEstimate = orderEstimateService
                .generateOrderEstimate(OrderEstimateMapper.INSTANCE.orderEstimateDTOToOrderEstimate(orderEstimateDTO));

        return OrderEstimateMapper.INSTANCE.orderEstimateToOrderEstimateDTO(orderEstimate);
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
