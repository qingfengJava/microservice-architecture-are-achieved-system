package com.gapache.cloud.auth.server.dao.repository.user;

import com.gapache.cloud.auth.server.dao.entity.UserEntity;
import com.gapache.jpa.BaseJpaRepository;

public interface UserRepository extends BaseJpaRepository<UserEntity, Long> {

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 用户
     */
    UserEntity findByUsername(String username);

    Boolean existsByUsername(String username);
}
