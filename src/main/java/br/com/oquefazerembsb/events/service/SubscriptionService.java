package br.com.oquefazerembsb.events.service;

import br.com.oquefazerembsb.events.dto.event.EventResponseDTO;
import br.com.oquefazerembsb.events.dto.subscription.SubscriptionResponseDTO;
import br.com.oquefazerembsb.events.dto.user.UserDTO;
import br.com.oquefazerembsb.events.exception.SubscriptionConflictException;
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

    public SubscriptionResponseDTO saveNewSubscription(String eventPrettyName, UserDTO userDTO) {

        // Se o evento não existir já lança uma exceção na camada EventService
        EventResponseDTO eventDTO = eventService.getByPrettyName(eventPrettyName);
        EventModel eventModel = eventService.mapToEventModel(eventDTO);

        // Se o usuario ja existir não salva um novo no DB, logica na camada UserService
        UserModel newUser = userService.saveNewUser(userDTO);

        // Valida se o usuario ja está inscrito no evento lança uma exceção
        var subscribedUser = repository.findByEventIDAndSubscriptionID(eventModel, newUser);
        if (subscribedUser != null) throw new SubscriptionConflictException("Já existe inscrição para o usuário " + newUser.getUserEmail() + " no evento " + eventModel.getTitle());

        SubscriptionModel subscriptionModel = new SubscriptionModel();
        subscriptionModel.setEventID(eventModel);
        subscriptionModel.setSubscriptionID(newUser);

        subscriptionModel.setIndicationID(subscribedUser.getIndicationID());
        return SubscriptionMapper.INSTANCE.subscriptionModelToSubscriptionResponseDTO(repository.save(subscriptionModel));
    }


}
