package org.zulfiqor.user_crud_and_search.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.zulfiqor.user_crud_and_search.dto.request.UserRequestDto;
import org.zulfiqor.user_crud_and_search.dto.request.UserSearchRequest;
import org.zulfiqor.user_crud_and_search.dto.response.GeneralResponse;
import org.zulfiqor.user_crud_and_search.model.entity.User;
import org.zulfiqor.user_crud_and_search.model.repository.UserRepository;
import org.zulfiqor.user_crud_and_search.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MessageSource messageSource;

    @Override
    public GeneralResponse searchUser(UserSearchRequest request) {
        List<User> userList = userRepository.searchUsers(request);
        return GeneralResponse.success(userList.isEmpty()? new ArrayList<>(): userList);
    }

    @Override
    public GeneralResponse getUser(Long userId){
        return GeneralResponse.success();
    }

    @Override
    public GeneralResponse createUser(UserRequestDto requestDto){
    return  GeneralResponse.success();
    }

    @Override
    public GeneralResponse updateUser(){
        return GeneralResponse.success();
    }
}
