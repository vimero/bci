package cl.bci.user.adapter.mapper;

import cl.bci.user.adapter.persistence.entity.UserEntity;
import cl.bci.user.application.model.UserRequest;
import cl.bci.user.application.model.UserResponse;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserEntity toEntity(UserRequest userRequest);

    UserResponse toUserResponse(UserEntity userEntity);

}
