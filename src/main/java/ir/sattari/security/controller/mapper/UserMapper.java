package ir.sattari.security.controller.mapper;

import ir.sattari.security.controller.model.UserResponseModel;
import ir.sattari.security.dal.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "username", source = "username")
    @Mapping(target = "accountExpired", source = "accountExpired")
    @Mapping(target = "accountLocked", source = "accountLocked")
    @Mapping(target = "enabled", source = "enabled")
    UserResponseModel userToUserResponseModel(User source);

}
