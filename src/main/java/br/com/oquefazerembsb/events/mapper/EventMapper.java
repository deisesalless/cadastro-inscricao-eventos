package br.com.oquefazerembsb.events.mapper;

import br.com.oquefazerembsb.events.dto.EventRequestDTO;
import br.com.oquefazerembsb.events.dto.EventResponseDTO;
import br.com.oquefazerembsb.events.model.EventModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    @Mapping(target = "eventID", ignore = true)
    @Mapping(target = "prettyName", ignore = true)
    EventModel eventRequestDTOtoEventModel(EventRequestDTO dto);

    EventModel eventResponseDTOtoEventModel(EventResponseDTO dto);

    EventResponseDTO eventModelToEventResponseDTO(EventModel event);

    List<EventResponseDTO> listEventModelToListEventResponseDTO(List<EventModel> list);
}
