package br.com.oquefazerembsb.events.service;

import br.com.oquefazerembsb.events.dto.event.EventRequestDTO;
import br.com.oquefazerembsb.events.dto.event.EventResponseDTO;
import br.com.oquefazerembsb.events.exception.EventNotFoundException;
import br.com.oquefazerembsb.events.mapper.EventMapper;
import br.com.oquefazerembsb.events.model.EventModel;
import br.com.oquefazerembsb.events.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public EventResponseDTO saveNewEvent(EventRequestDTO dto) {
        EventModel eventModel = EventMapper.INSTANCE.eventRequestDTOtoEventModel(dto);

        String prettyName = generatePrettyName(eventModel.getTitle());
        eventModel.setPrettyName(prettyName);

        return EventMapper.INSTANCE.eventModelToEventResponseDTO(repository.save(eventModel));
    }

    public List<EventResponseDTO> getAllEvents() {
        List<EventModel> list = repository.findAll();
        return EventMapper.INSTANCE.listEventModelToListEventResponseDTO(list);
    }

    public EventResponseDTO getByPrettyName(String prettyName) {
        EventModel eventModel = repository.findByPrettyName(prettyName);
        if (eventModel == null) throw new EventNotFoundException("Evento não encontrado");

        return EventMapper.INSTANCE.eventModelToEventResponseDTO(eventModel);
    }

    private String generatePrettyName(String title) {
        return title != null ? title.toLowerCase().
                replaceAll("\\s+|\\b(de|da|do)\\b", "-").
                replaceAll("-{2,}", "-") : null;
    }

    public EventModel mapToEventModel(EventResponseDTO dto) {
        return EventMapper.INSTANCE.eventResponseDTOtoEventModel(dto);
    }

}
