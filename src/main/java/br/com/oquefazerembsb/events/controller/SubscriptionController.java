package br.com.oquefazerembsb.events.controller;

import br.com.oquefazerembsb.events.dto.subscription.SubscriptionResponseDTO;
import br.com.oquefazerembsb.events.dto.user.UserDTO;
import br.com.oquefazerembsb.events.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService service;

    @PostMapping("/{prettyName}")
    public ResponseEntity<SubscriptionResponseDTO> createNewSubscription(@PathVariable String prettyName, @RequestBody UserDTO dto) {
        SubscriptionResponseDTO subscriptionResponse = service.saveNewSubscription(prettyName, dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{subscriptionNumber}")
                .buildAndExpand(subscriptionResponse.getSubscriptionNumber()).toUri();

        return ResponseEntity.created(location).body(subscriptionResponse);
    }
}
