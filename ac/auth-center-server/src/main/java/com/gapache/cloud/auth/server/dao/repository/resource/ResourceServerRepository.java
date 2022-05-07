package com.gapache.cloud.auth.server.dao.repository.resource;

import com.gapache.cloud.auth.server.dao.entity.ResourceServerEntity;
import com.gapache.jpa.BaseJpaRepository;

/**
 * @author 清风学Java
 * @since 2021/1/26 2:15 下午
 */
public interface ResourceServerRepository extends BaseJpaRepository<ResourceServerEntity, Long> {

    ResourceServerEntity findByName(String name);
}
