package br.com.oquefazerembsb.events.repository;

import br.com.oquefazerembsb.events.model.EventModel;
import br.com.oquefazerembsb.events.model.SubscriptionModel;
import br.com.oquefazerembsb.events.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionModel, Integer> {

    SubscriptionModel findByEventIDAndSubscriptionID(EventModel eventID, UserModel subscriptionID);
}
