package org.zulfiqor.user_crud_and_search.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequestDTO {
    private String nameUz;
    private String nameRu;
    private String nameEn;

}