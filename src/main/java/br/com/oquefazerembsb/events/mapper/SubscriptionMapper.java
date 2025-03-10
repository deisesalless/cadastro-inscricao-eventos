package br.com.oquefazerembsb.events.mapper;

import br.com.oquefazerembsb.events.dto.subscription.SubscriptionResponseDTO;
import br.com.oquefazerembsb.events.model.SubscriptionModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface SubscriptionMapper {

    @Mapping(source = "eventID", target = "event")
    @Mapping(source = "subscriptionID", target = "subscription")
    @Mapping(source = "indicationID", target = "indication")
    SubscriptionResponseDTO mapToSubscriptionResponseDTO(SubscriptionModel subscription);
}
