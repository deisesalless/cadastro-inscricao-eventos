package br.com.oquefazerembsb.events.mapper;

import br.com.oquefazerembsb.events.dto.UserRequestDTO;
import br.com.oquefazerembsb.events.dto.UserResponseDTO;
import br.com.oquefazerembsb.events.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserModel userRequestDTOtoUserModel(UserRequestDTO dto);

    UserModel userResponseDTOtoUserModel(UserResponseDTO dto);

    UserResponseDTO userModelToUserResponseDTO(UserModel user);


}
