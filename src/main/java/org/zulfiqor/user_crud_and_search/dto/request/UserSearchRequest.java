package org.zulfiqor.user_crud_and_search.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearchRequest {

    private String firstname;
    private String lastname;
    private String username;
    private String middleName;
    private String role;
    private String address;
    private String regionId;
    private String districtId;
    private Long departmentId;
}
