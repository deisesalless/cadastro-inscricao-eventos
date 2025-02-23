package br.com.oquefazerembsb.events.service;

import br.com.oquefazerembsb.events.dto.EventResponseDTO;
import br.com.oquefazerembsb.events.dto.SubscriptionResponseDTO;
import br.com.oquefazerembsb.events.dto.UserRequestDTO;
import br.com.oquefazerembsb.events.dto.UserResponseDTO;
import br.com.oquefazerembsb.events.exception.EventNotFoundException;
import br.com.oquefazerembsb.events.mapper.SubscriptionMapper;
import br.com.oquefazerembsb.events.model.EventModel;
import br.com.oquefazerembsb.events.model.SubscriptionModel;
import br.com.oquefazerembsb.events.model.UserModel;
import br.com.oquefazerembsb.events.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @Autowired
    private SubscriptionRepository repository;

    public SubscriptionResponseDTO saveNewSubscription(String eventPrettyName, UserRequestDTO userDTO) {
        EventResponseDTO eventDTO = eventService.getByPrettyName(eventPrettyName);
        EventModel eventModel = eventService.mapToEventModel(eventDTO);

        UserResponseDTO userRecuperado = userService.getByEmail(userDTO.getUserEmail());
        if (userRecuperado == null) {
            userRecuperado = userService.saveNewUser(userDTO);
        }

        SubscriptionModel subscriptionModel = new SubscriptionModel();
        subscriptionModel.setEventID(eventModel);
        subscriptionModel.setSubscriptionID(userService.mapToUserModel(userRecuperado));
//        subscriptionModel.setIndicationID();

        return SubscriptionMapper.INSTANCE.subscriptionModelToSubscriptionResponseDTO(repository.save(subscriptionModel));
    }


}
