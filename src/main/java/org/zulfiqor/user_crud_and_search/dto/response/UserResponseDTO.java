package org.zulfiqor.user_crud_and_search.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String middleName;
    private DepartmentResponseDTO department;
    private AddressResponseDTO address;
    private Set<RoleResponseDTO> roles;

}
