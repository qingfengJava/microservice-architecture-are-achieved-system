package com.gapache.cloud.auth.server.dao.repository.resource;

import com.gapache.cloud.auth.server.dao.entity.ResourceServerEntity;
import com.gapache.jpa.BaseJpaRepository;

public interface ResourceServerRepository extends BaseJpaRepository<ResourceServerEntity, Long> {

    ResourceServerEntity findByName(String name);
}
