package org.zulfiqor.user_crud_and_search.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequestDto {

    private String firstname;
    private String lastname;
    private String username;
    private String middleName;
    private DepartmentRequestDTO department;
    private AddressRequestDTO address;
    private List<RoleRequestDTO> roles;
}
