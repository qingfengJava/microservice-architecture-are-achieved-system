package com.gapache.cloud.auth.server.dao.repository.user;

import com.gapache.cloud.auth.server.dao.entity.UserRoleEntity;
import com.gapache.jpa.BaseJpaRepository;

public interface UserRoleRepository extends BaseJpaRepository<UserRoleEntity, Long> {

    UserRoleEntity findByUserId(Long userId);
}
