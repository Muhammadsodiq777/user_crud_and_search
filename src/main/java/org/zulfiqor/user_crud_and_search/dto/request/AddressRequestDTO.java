package org.zulfiqor.user_crud_and_search.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.zulfiqor.user_crud_and_search.dto.response.DistrictResponseDTO;
import org.zulfiqor.user_crud_and_search.dto.response.RegionResponseDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequestDTO {
    private String address;
    private RegionResponseDTO region;
    private DistrictResponseDTO district;
}
