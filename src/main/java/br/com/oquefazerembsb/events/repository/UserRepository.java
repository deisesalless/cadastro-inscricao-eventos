package br.com.oquefazerembsb.events.repository;

import br.com.oquefazerembsb.events.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserModel, Integer> {

    UserModel findByEmail(String email);
}
