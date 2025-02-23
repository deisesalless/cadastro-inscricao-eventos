package br.com.oquefazerembsb.events.service;

import br.com.oquefazerembsb.events.dto.user.UserRequestDTO;
import br.com.oquefazerembsb.events.dto.user.UserResponseDTO;
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
        UserModel userModel = repository.save(UserMapper.INSTANCE.userRequestDTOtoUserModel(dto));
        return UserMapper.INSTANCE.userModelToUserResponseDTO(userModel);
    }

    public UserResponseDTO getById(Integer id) {
        UserModel userModel = repository.findById(id).get();
        return UserMapper.INSTANCE.userModelToUserResponseDTO(userModel);
    }

    public UserResponseDTO getByEmail(String email) {
        UserModel userModel = repository.findByUserEmail(email);
        return UserMapper.INSTANCE.userModelToUserResponseDTO(userModel);
    }

    public UserModel mapToUserModel(UserResponseDTO dto) {
        return UserMapper.INSTANCE.userResponseDTOtoUserModel(dto);
    }
}
