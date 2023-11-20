package pucrs.promotionservice.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pucrs.promotionservice.domain.models.Promotion;
import pucrs.promotionservice.application.dto.PromotionDTO;

import java.util.List;

@Mapper
public interface PromotionMapper {
    PromotionMapper INSTANCE = Mappers.getMapper(PromotionMapper.class);

    PromotionDTO promotionToPromotionDTO(Promotion promotion);

    List<PromotionDTO> promotionListToPromotionDTO(List<Promotion> promotionList);
}