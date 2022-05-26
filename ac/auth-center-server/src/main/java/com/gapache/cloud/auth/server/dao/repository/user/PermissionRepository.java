package com.gapache.cloud.auth.server.dao.repository.user;

import com.gapache.cloud.auth.server.dao.entity.PermissionEntity;
import com.gapache.jpa.BaseJpaRepository;

import java.util.Collection;
import java.util.List;


public interface PermissionRepository extends BaseJpaRepository<PermissionEntity, Long> {

    List<PermissionEntity> findAllByResourceIdIn(Collection<Long> resourceIds);
}
