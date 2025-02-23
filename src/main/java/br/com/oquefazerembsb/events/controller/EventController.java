package br.com.oquefazerembsb.events.controller;

import br.com.oquefazerembsb.events.dto.event.EventRequestDTO;
import br.com.oquefazerembsb.events.dto.event.EventResponseDTO;
import br.com.oquefazerembsb.events.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<EventResponseDTO>> getAllEvents() {
        return ResponseEntity.ok(service.getAllEvents());
    }

    @GetMapping("/{prettyName}")
    public ResponseEntity<EventResponseDTO> getByPrettyname(@PathVariable String prettyName) {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getByPrettyName(prettyName));
    }
}
