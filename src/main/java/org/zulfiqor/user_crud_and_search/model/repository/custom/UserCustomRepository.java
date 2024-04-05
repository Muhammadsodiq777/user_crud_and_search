package org.zulfiqor.user_crud_and_search.model.repository.custom;

import org.zulfiqor.user_crud_and_search.dto.request.UserSearchRequest;
import org.zulfiqor.user_crud_and_search.model.entity.User;

import java.util.List;

public interface UserCustomRepository {
    List<User> searchUsers(UserSearchRequest request);
}
