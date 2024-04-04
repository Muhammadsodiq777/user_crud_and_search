package org.zulfiqor.user_crud_and_search.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.zulfiqor.user_crud_and_search.model.entity.base.BaseAuditEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
@Entity
public class Role extends BaseAuditEntity {

    private String nameUz;
    private String nameRu;
    private String nameEn;
    private Integer orders;
}
