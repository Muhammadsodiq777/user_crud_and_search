package org.zulfiqor.user_crud_and_search.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zulfiqor.user_crud_and_search.dto.request.UserRequestDto;
import org.zulfiqor.user_crud_and_search.dto.request.UserSearchRequest;
import org.zulfiqor.user_crud_and_search.dto.response.GeneralResponse;
import org.zulfiqor.user_crud_and_search.dto.response.UserResponseDTO;
import org.zulfiqor.user_crud_and_search.mapper.UserMapper;
import org.zulfiqor.user_crud_and_search.model.entity.User;
import org.zulfiqor.user_crud_and_search.model.repository.UserRepository;
import org.zulfiqor.user_crud_and_search.service.UserService;
import org.zulfiqor.user_crud_and_search.service.source.MessageSourceService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.zulfiqor.user_crud_and_search.consts.Locale.NOT_FOUND_EMPLOYEE;
import static org.zulfiqor.user_crud_and_search.exceptions.HttpResponseCode.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MessageSourceService messageSourceService;
    private final UserMapper userMapper;

    @Override
    public GeneralResponse searchUser(UserSearchRequest request) {
        List<UserResponseDTO> response = userMapper.toResponseList(userRepository.searchUsers(request));
        return GeneralResponse.success(response.isEmpty()? new ArrayList<>(): response);
    }

    @Override
    public GeneralResponse getUser(Long userId){
        Optional<User> byId = userRepository.findUserByIdAndActive(userId, true);
        return byId.map(user ->
                GeneralResponse.success(userMapper.toResponse(user))).orElseGet(() ->
                GeneralResponse.error(NOT_FOUND.getCode(), messageSourceService.getMessage(NOT_FOUND_EMPLOYEE, "uz")));
    }

    @Override
    public GeneralResponse createUser(UserRequestDto requestDto){
        User entity = userMapper.toEntity(requestDto);
        userRepository.save(entity);
        return  GeneralResponse.success(CREATED);
    }

    @Override
    public GeneralResponse updateUser(UserRequestDto requestDto){
        return GeneralResponse.success();
    }

    @Override
    public GeneralResponse deleteUser(Long userId){
        Optional<User> byId = userRepository.findById(userId);
        if(byId.isEmpty())
            return GeneralResponse.error(NOT_FOUND.getCode(), messageSourceService.getMessage(NOT_FOUND_EMPLOYEE, "uz"));
        User user = byId.get();
        user.setActive(false);
        userRepository.save(user);
        return GeneralResponse.success(SUCCESS);
    }
}
