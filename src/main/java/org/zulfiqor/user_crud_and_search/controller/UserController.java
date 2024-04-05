package org.zulfiqor.user_crud_and_search.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zulfiqor.user_crud_and_search.dto.request.UserRequestDto;
import org.zulfiqor.user_crud_and_search.dto.request.UserSearchRequest;
import org.zulfiqor.user_crud_and_search.dto.response.GeneralResponse;
import org.zulfiqor.user_crud_and_search.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("search")
    public ResponseEntity<?> searchUser(@RequestBody UserSearchRequest request){
        return ResponseEntity.ok(userService.searchUser(request));
    }

    @GetMapping("find/{userId}")
    public GeneralResponse getUserById(@PathVariable(name = "userId") Long userId){
        return userService.getUser(userId);
    }

    @PostMapping("create")
    public GeneralResponse createUser(@RequestBody UserRequestDto request){
        return userService.createUser(request);
    }

    @PatchMapping("update")
    public GeneralResponse searchUser(@RequestBody UserRequestDto request){
        return userService.updateUser(request);
    }

    @DeleteMapping("delete/{userId}")
    public GeneralResponse deleteUser(@PathVariable(name = "userId") Long userId){
        return userService.deleteUser(userId);
    }
}
