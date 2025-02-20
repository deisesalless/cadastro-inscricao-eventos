package br.com.oquefazerembsb.events.mapper;

import br.com.oquefazerembsb.events.dto.EventRequestDTO;
import br.com.oquefazerembsb.events.dto.EventResponseDTO;
import br.com.oquefazerembsb.events.model.EventModel;

import java.util.List;
import java.util.stream.Collectors;

public class EventMapper {

    public static EventModel toModel(EventRequestDTO dto) {
        EventModel eventModel = new EventModel();

        eventModel.setTitle(dto.getTitle());
        eventModel.setPrettyName(generatePrettyName(dto.getTitle()));
        eventModel.setLocation(dto.getLocation());
        eventModel.setPrice(dto.getPrice());
        eventModel.setStartDate(dto.getStartDate());
        eventModel.setEndDate(dto.getEndDate());
        eventModel.setStartTime(dto.getStartTime());
        eventModel.setEndTime(dto.getEndTime());

        return eventModel;
    }

    private static String generatePrettyName(String title) {
        return title != null ? title.toLowerCase().
                replaceAll("\\s+|\\b(de|da|do)\\b", "-").
                replaceAll("-{2,}", "-") : null;
    }

    public static EventResponseDTO toDTO (EventModel event) {
        return new EventResponseDTO(event.getEventID(), event.getTitle(),
                event.getPrettyName(), event.getLocation(), event.getPrice(),
                event.getStartDate(), event.getEndDate(), event.getStartTime(),
                event.getEndTime());
    }

    public static List<EventResponseDTO> toResponseDTOList(List<EventModel> modelList) {
        List<EventResponseDTO> dtoList = modelList.stream()
                .map(EventMapper::toDTO) // Mapeia cada EventModel para EventResponseDTO
                .collect(Collectors.toList());
        return dtoList;
    }
}

