package org.zulfiqor.user_crud_and_search.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zulfiqor.user_crud_and_search.dto.request.UserSearchRequest;
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
}
