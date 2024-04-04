package org.zulfiqor.user_crud_and_search.model.repository.custom.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.zulfiqor.user_crud_and_search.model.entity.Department;
import org.zulfiqor.user_crud_and_search.model.entity.User;
import org.zulfiqor.user_crud_and_search.model.repository.custom.UserCustomRepository;

import java.util.ArrayList;
import java.util.List;

public class UserCustomRepositoryImpl implements UserCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> searchUserByFirstName(String firstName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> productsCriteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> productsRoot = productsCriteriaQuery.from(User.class);
        List<Predicate> predicateList = new ArrayList<>();
        return null;
    }

    @Override
    public List<User> searchUserByLastName(String lastName) {
        return null;
    }

    @Override
    public List<User> searchUserByMiddleName(String middleName) {
        return null;
    }

    @Override
    public List<User> searchUserByUserName(String username) {
        return null;
    }

    @Override
    public List<Department> searchDepartment(String name) {
        return null;
    }

    @Override
    public List<User> searchUserByRole(String roleName) {
        return null;
    }

    @Override
    public List<User> searchUserByAddressName(String address) {
        return null;
    }

    @Override
    public List<User> searchUserByAddressUsingRegion(String address) {
        return null;
    }
}
