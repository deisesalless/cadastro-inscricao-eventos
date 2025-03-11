package br.com.oquefazerembsb.events.mapper;

import br.com.oquefazerembsb.events.dto.event.EventRequestDTO;
import br.com.oquefazerembsb.events.dto.event.EventResponseDTO;
import br.com.oquefazerembsb.events.model.EventModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface EventMapper {

    @Mapping(target = "eventID", ignore = true)
    @Mapping(target = "prettyName", ignore = true)
    EventModel mapToEventModel(EventRequestDTO dto);

    EventModel mapToEventModel(EventResponseDTO dto);

    EventResponseDTO mapToEventResponseDTO(EventModel event);

    List<EventResponseDTO> mapToListEventResponseDTO(List<EventModel> list);
}