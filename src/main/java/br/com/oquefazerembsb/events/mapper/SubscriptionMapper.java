package br.com.oquefazerembsb.events.mapper;

import br.com.oquefazerembsb.events.dto.subscription.SubscriptionResponseDTO;
import br.com.oquefazerembsb.events.model.SubscriptionModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubscriptionMapper {

    SubscriptionMapper INSTANCE = Mappers.getMapper(SubscriptionMapper.class);

    @Mapping(source = "eventID", target = "eventID")
    SubscriptionResponseDTO subscriptionModelToSubscriptionResponseDTO(SubscriptionModel subscription);
}
