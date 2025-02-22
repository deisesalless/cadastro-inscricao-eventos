package br.com.oquefazerembsb.events.service;

import br.com.oquefazerembsb.events.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
}
