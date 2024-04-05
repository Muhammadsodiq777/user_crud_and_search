package org.zulfiqor.user_crud_and_search.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DistrictResponseDTO {
    private String nameUz;
    private String nameRu;
    private String nameEn;
}
