package br.com.oquefazerembsb.events.mapper;

import br.com.oquefazerembsb.events.dto.user.UserDTO;
import br.com.oquefazerembsb.events.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserModel userDTOtoUserModel(UserDTO dto);

    UserDTO userModelToUserDTO(UserModel user);


}
