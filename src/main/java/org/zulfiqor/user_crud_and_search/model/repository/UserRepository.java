package org.zulfiqor.user_crud_and_search.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.zulfiqor.user_crud_and_search.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
