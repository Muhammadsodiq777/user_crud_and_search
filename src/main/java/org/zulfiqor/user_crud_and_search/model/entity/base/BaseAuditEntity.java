package org.zulfiqor.user_crud_and_search.model.entity.base;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseAuditEntity extends BaseEntity {

    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String updatedBy;
}