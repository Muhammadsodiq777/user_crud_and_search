package org.zulfiqor.user_crud_and_search.mapper;

import org.mapstruct.Mapper;
import org.zulfiqor.user_crud_and_search.dto.request.UserRequestDto;
import org.zulfiqor.user_crud_and_search.dto.response.UserResponseDTO;
import org.zulfiqor.user_crud_and_search.model.entity.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDTO toResponse(User users);

    List<UserResponseDTO> toResponseList(List<User> users);

    User toEntity(UserRequestDto requestDto);
}
