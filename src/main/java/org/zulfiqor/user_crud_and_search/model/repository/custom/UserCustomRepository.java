package org.zulfiqor.user_crud_and_search.model.repository.custom;

import org.zulfiqor.user_crud_and_search.model.entity.Department;
import org.zulfiqor.user_crud_and_search.model.entity.User;

import java.util.List;

public interface UserCustomRepository {

    List<User> searchUserByFirstName(String firstName);
    List<User> searchUserByLastName(String lastName);
    List<User> searchUserByMiddleName(String middleName);
    List<User> searchUserByUserName(String username);
    List<Department> searchDepartment(String name);
    List<User> searchUserByRole(String roleName);
    List<User> searchUserByAddressName(String address);
    List<User> searchUserByAddressUsingRegion(String address);
}
