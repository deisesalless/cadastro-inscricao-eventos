package br.com.oquefazerembsb.events.repository;

import br.com.oquefazerembsb.events.model.SubscriptionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<SubscriptionModel, Integer> {
}
