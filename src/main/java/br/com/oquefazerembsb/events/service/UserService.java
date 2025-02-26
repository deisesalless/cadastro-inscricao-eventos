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

    public UserModel saveNewUser(UserDTO dto) {
        var userRecover = getByEmail(dto.getUserEmail());
        if (userRecover == null) return  repository.save(UserMapper.INSTANCE.userDTOtoUserModel(dto));
        return userRecover;
    }

    public UserDTO getById(Integer id) {
        UserModel userModel = repository.findById(id).get();
        return UserMapper.INSTANCE.userModelToUserDTO(userModel);
    }

    public UserModel getByEmail(String email) {
        return repository.findByUserEmail(email);
    }

    public UserModel mapToUserModel(UserDTO dto) {
        return UserMapper.INSTANCE.userDTOtoUserModel(dto);
    }
}
