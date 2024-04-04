package org.zulfiqor.user_crud_and_search.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.zulfiqor.user_crud_and_search.model.entity.base.BaseAuditEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "region")
@Entity
class Region extends BaseAuditEntity {

    private String nameUz;
    private String nameRu;
    private String nameEn;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<District> district = new ArrayList<>();
}