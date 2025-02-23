package br.com.oquefazerembsb.events.mapper;

import br.com.oquefazerembsb.events.dto.user.UserRequestDTO;
import br.com.oquefazerembsb.events.dto.user.UserResponseDTO;
import br.com.oquefazerembsb.events.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "userID", ignore = true)
    UserModel userRequestDTOtoUserModel(UserRequestDTO dto);

    UserModel userResponseDTOtoUserModel(UserResponseDTO dto);

    UserResponseDTO userModelToUserResponseDTO(UserModel user);


}
