package org.zulfiqor.user_crud_and_search.model.repository.specification;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.FluentQuery;
import org.zulfiqor.user_crud_and_search.model.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class UserSpecification implements JpaSpecificationExecutor<User> {
    @Override
    public Optional<User> findOne(Specification<User> spec) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll(Specification<User> spec) {
        return null;
    }

    @Override
    public Page<User> findAll(Specification<User> spec, Pageable pageable) {
        return null;
    }

    @Override
    public List<User> findAll(Specification<User> spec, Sort sort) {
        return null;
    }

    @Override
    public long count(Specification<User> spec) {
        return 0;
    }

    @Override
    public boolean exists(Specification<User> spec) {
        return false;
    }

    @Override
    public long delete(Specification<User> spec) {
        return 0;
    }

    @Override
    public <S extends User, R> R findBy(Specification<User> spec, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
