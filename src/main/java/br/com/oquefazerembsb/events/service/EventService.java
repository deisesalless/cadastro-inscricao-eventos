package br.com.oquefazerembsb.events.service;

import br.com.oquefazerembsb.events.dto.event.EventRequestDTO;
import br.com.oquefazerembsb.events.dto.event.EventResponseDTO;
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
        EventModel newEvent = EventMapper.toModel(dto);
        return EventMapper.toDTO(repository.save(newEvent));
    }

    public List<EventResponseDTO> getAllEvents() {
        List<EventModel> list = repository.findAll();
        return EventMapper.toResponseDTOList(list);
    }

    public EventResponseDTO getByPrettyName(String prettyName) {
        return EventMapper.toDTO(repository.findByPrettyName(prettyName));
    }

}
