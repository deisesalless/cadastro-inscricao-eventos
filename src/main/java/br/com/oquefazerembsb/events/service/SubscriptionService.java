package br.com.oquefazerembsb.events.service;

import br.com.oquefazerembsb.events.dto.event.EventResponseDTO;
import br.com.oquefazerembsb.events.dto.subscription.SubscriptionResponseDTO;
import br.com.oquefazerembsb.events.dto.user.UserRequestDTO;
import br.com.oquefazerembsb.events.dto.user.UserResponseDTO;
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

        UserResponseDTO newUserDTO = userService.saveNewUser(userDTO);
        UserModel userModel = userService.mapToUserModel(newUserDTO);

        SubscriptionModel subscriptionModel = new SubscriptionModel();
        subscriptionModel.setEventID(eventModel);
        subscriptionModel.setSubscriptionID(userModel);

        return SubscriptionMapper.INSTANCE.subscriptionModelToSubscriptionResponseDTO(repository.save(subscriptionModel));
    }


}
