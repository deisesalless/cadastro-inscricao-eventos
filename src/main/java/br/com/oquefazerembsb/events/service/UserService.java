package br.com.oquefazerembsb.events.service;

import br.com.oquefazerembsb.events.dto.user.*;
import br.com.oquefazerembsb.events.mapper.UserMapper;
import br.com.oquefazerembsb.events.model.UserModel;
import br.com.oquefazerembsb.events.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper userMapper;

    public UserModel saveNewUser(UserDTO dto) {
        var userRecover = getByEmail(dto.getUserEmail());
        if (userRecover == null) return  repository.save(userMapper.mapToNewUserModel(dto));
        return userRecover;
    }

    public UserDTO getById(Integer id) {
        UserModel userModel = repository.findById(id).get();
        return userMapper.mapToUserDTO(userModel);
    }

    public UserModel getByEmail(String email) {
        return repository.findByUserEmail(email);
    }

}
