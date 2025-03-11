package br.com.oquefazerembsb.events.dto.subscription;


import br.com.oquefazerembsb.events.model.EventModel;
import br.com.oquefazerembsb.events.model.UserModel;
import lombok.Data;

@Data
public class SubscriptionResponseDTO {
    private Integer subscriptionNumber;
    private EventModel event;
    private UserModel subscription;
    private UserModel indication;
//    private String designation;
}
