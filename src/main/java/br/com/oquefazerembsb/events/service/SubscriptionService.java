package br.com.oquefazerembsb.events.service;

import br.com.oquefazerembsb.events.dto.EventResponseDTO;
import br.com.oquefazerembsb.events.dto.UserRequestDTO;
import br.com.oquefazerembsb.events.dto.UserResponseDTO;
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

    public SubscriptionModel saveNewSubscription(String eventPrettyName, UserRequestDTO userDTO) {
        EventResponseDTO eventDTO = eventService.getByPrettyName(eventPrettyName);

        UserResponseDTO newUserDTO = userService.saveNewUser(userDTO);
        UserModel userModel = userService.mapToUserModel(newUserDTO);

        SubscriptionModel subscriptionModel = new SubscriptionModel();

//        subscriptionModel.setEventID(eventDTO.getEventID());

        subscriptionModel.setSubscriptionID(userModel);


        repository.save(subscriptionModel);

        return null;
    }


}
