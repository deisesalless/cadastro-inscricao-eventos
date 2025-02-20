package br.com.oquefazerembsb.events.controller;

import br.com.oquefazerembsb.events.dto.EventRequestDTO;
import br.com.oquefazerembsb.events.dto.EventResponseDTO;
import br.com.oquefazerembsb.events.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    @PostMapping
    public ResponseEntity<EventResponseDTO> createNewEvent(@RequestBody @Validated EventRequestDTO dto) {
        EventResponseDTO eventResponse = service.saveNewEvent(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(eventResponse.getEventID()).toUri();

        return ResponseEntity.created(location).body(eventResponse);
    }


}
