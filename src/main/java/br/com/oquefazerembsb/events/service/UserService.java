package br.com.oquefazerembsb.events.service;

import br.com.oquefazerembsb.events.dto.UserRequestDTO;
import br.com.oquefazerembsb.events.dto.UserResponseDTO;
import br.com.oquefazerembsb.events.mapper.UserMapper;
import br.com.oquefazerembsb.events.model.UserModel;
import br.com.oquefazerembsb.events.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserResponseDTO saveNewUser(UserRequestDTO dto) {
        UserModel userModel = repository.save(UserMapper.INSTANCE.userDTOtoUserModel(dto));
        return UserMapper.INSTANCE.userModelToUserDTO(userModel);
    }

    public UserResponseDTO getById(Integer id) {
        UserModel userModel = repository.findById(id).get();
        return UserMapper.INSTANCE.userModelToUserDTO(userModel);
    }
}
