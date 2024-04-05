package org.zulfiqor.user_crud_and_search.model.repository.custom;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Service;
import org.zulfiqor.user_crud_and_search.dto.request.UserSearchRequest;
import org.zulfiqor.user_crud_and_search.model.entity.Address;
import org.zulfiqor.user_crud_and_search.model.entity.Department;
import org.zulfiqor.user_crud_and_search.model.entity.Role;
import org.zulfiqor.user_crud_and_search.model.entity.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserCustomRepositoryImpl implements UserCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> searchUsers(UserSearchRequest request) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = criteriaQuery.from(User.class);
        List<Predicate> predicates = new ArrayList<>();

        //  user attributes
        addAttributePredicate(criteriaBuilder, predicates, userRoot.get("firstname"), request.getFirstname());
        addAttributePredicate(criteriaBuilder, predicates, userRoot.get("lastname"), request.getLastname());
        addAttributePredicate(criteriaBuilder, predicates, userRoot.get("username"), request.getUsername());
        addAttributePredicate(criteriaBuilder, predicates, userRoot.get("middleName"), request.getMiddleName());

        //  role
        if (StringUtils.isNotBlank(request.getRole())) {
            Join<User, Role> roleJoin = userRoot.join("roles");
            predicates.add(criteriaBuilder.or(
                    criteriaBuilder.like(roleJoin.get("nameUz"), "%" + request.getRole() + "%"),
                    criteriaBuilder.like(roleJoin.get("nameRu"), "%" + request.getRole() + "%"),
                    criteriaBuilder.like(roleJoin.get("nameEn"), "%" + request.getRole() + "%")
            ));
        }

        //  department
        if (request.getDepartmentId() != null) {
            Join<User, Department> departmentJoin = userRoot.join("department");
            if (isParentDepartment(request.getDepartmentId())) {
                Subquery<Long> subquery = criteriaQuery.subquery(Long.class);
                Root<Department> subDepartmentRoot = subquery.from(Department.class);
                subquery.select(subDepartmentRoot.get("id"));
                subquery.where(criteriaBuilder.equal(subDepartmentRoot.get("parent").get("id"), request.getDepartmentId()));
                predicates.add(criteriaBuilder.in(departmentJoin.get("id")).value(subquery));
            } else {
                predicates.add(criteriaBuilder.equal(departmentJoin.get("id"), request.getDepartmentId()));
            }
        }

        //  address attributes
        if (StringUtils.isNotBlank(request.getAddress())) {
            Join<User, Address> addressJoin = userRoot.join("address");
            predicates.add(criteriaBuilder.like(addressJoin.get("address"), "%" + request.getAddress() + "%"));
        }
        if (StringUtils.isNotBlank(request.getRegionId())) {
            Join<User, Address> addressJoin = userRoot.join("address");
            predicates.add(criteriaBuilder.equal(addressJoin.get("region").get("id"), request.getRegionId()));
        }
        if (StringUtils.isNotBlank(request.getDistrictId())) {
            Join<User, Address> addressJoin = userRoot.join("address");
            predicates.add(criteriaBuilder.equal(addressJoin.get("region").get("district").get("id"), request.getDistrictId()));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        TypedQuery<User> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    private void addAttributePredicate(CriteriaBuilder criteriaBuilder, List<Predicate> predicates, Path<String> attributePath, String value) {
        if (StringUtils.isNotBlank(value)) {
            predicates.add(criteriaBuilder.like(attributePath, "%" + value + "%"));
        }
    }

    private boolean isParentDepartment(Long departmentId) {
        Department department = entityManager.find(Department.class, departmentId);
        return department != null && department.getParent() == null;
    }

}
