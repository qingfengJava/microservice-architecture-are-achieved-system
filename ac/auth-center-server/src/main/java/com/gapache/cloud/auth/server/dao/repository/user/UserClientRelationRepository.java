package com.gapache.cloud.auth.server.dao.repository.user;

import com.gapache.cloud.auth.server.dao.entity.UserClientRelationEntity;
import com.gapache.jpa.BaseJpaRepository;

public interface UserClientRelationRepository extends BaseJpaRepository<UserClientRelationEntity, Long> {

    UserClientRelationEntity findByUserIdAndClientId(Long userId, Long clientId);

    Boolean existsByUserIdAndClientId(Long userId, Long clientId);
}
