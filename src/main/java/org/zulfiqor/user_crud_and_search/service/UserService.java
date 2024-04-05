package org.zulfiqor.user_crud_and_search.service;

import org.zulfiqor.user_crud_and_search.dto.request.UserRequestDto;
import org.zulfiqor.user_crud_and_search.dto.request.UserSearchRequest;
import org.zulfiqor.user_crud_and_search.dto.response.GeneralResponse;

public interface UserService {
    GeneralResponse searchUser(UserSearchRequest request);

    GeneralResponse getUser(Long userId);

    GeneralResponse createUser(UserRequestDto requestDto);

    GeneralResponse updateUser();
}
