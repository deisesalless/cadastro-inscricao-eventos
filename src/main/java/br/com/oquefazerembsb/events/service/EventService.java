package br.com.oquefazerembsb.events.service;

import br.com.oquefazerembsb.events.model.EventModel;
import br.com.oquefazerembsb.events.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public EventModel saveNewEvent(EventModel event) {
        EventModel newEvent = repository.save(event);
        return newEvent;
    }
}
