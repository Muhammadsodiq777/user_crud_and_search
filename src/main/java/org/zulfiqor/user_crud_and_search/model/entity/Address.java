package org.zulfiqor.user_crud_and_search.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "address")
@Entity
public class Address extends BaseAuditEntity {

    private String address;
    
    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    private Region region;
}
