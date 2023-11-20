package pucrs.orderestimateservice.application.mapper;

import pucrs.orderestimateservice.application.dto.OrderEstimateDTO;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pucrs.orderestimateservice.domain.models.OrderEstimate;

@Mapper
public interface OrderEstimateMapper {
    OrderEstimateMapper INSTANCE = Mappers.getMapper(OrderEstimateMapper.class);

    OrderEstimateDTO orderEstimateToOrderEstimateDTO(OrderEstimate orderEstimate);
    List<OrderEstimateDTO> orderEstimateListToOrderEstimateDTOList(List<OrderEstimate> orderEstimateList);
    OrderEstimate orderEstimateDTOToOrderEstimate(OrderEstimateDTO orderEstimateDTO);
}
