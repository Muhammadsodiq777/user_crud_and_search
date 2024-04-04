package org.zulfiqor.user_crud_and_search.model.entity;

import jakarta.persistence.*;
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
@Table(name = "department")
@Entity
public class Department extends BaseAuditEntity {

    private String nameUz;
    private String nameRu;
    private String nameEn;
    private Integer orders;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Department parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Department> children = new ArrayList<>();

}