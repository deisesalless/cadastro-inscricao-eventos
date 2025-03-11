package br.com.oquefazerembsb.events.mapper;

import br.com.oquefazerembsb.events.dto.user.UserDTO;
import br.com.oquefazerembsb.events.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {

    @Mapping(target = "userID", ignore = true)
    UserModel mapToNewUserModel(UserDTO dto);

    UserDTO mapToUserDTO(UserModel user);


}
