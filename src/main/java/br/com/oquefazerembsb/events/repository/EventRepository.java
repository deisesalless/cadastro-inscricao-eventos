package br.com.oquefazerembsb.events.repository;

import br.com.oquefazerembsb.events.model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventModel, Integer> {

    EventModel findByPrettyName(String prettyName);
}
