package com.gapache.cloud.auth.server.dao.repository.resource;

import com.gapache.cloud.auth.server.dao.entity.ResourceEntity;

import java.util.List;

public interface ResourceDao {

    List<ResourceEntity> findAllResource(Long userId);

    List<ResourceEntity> findCustomizeAllResourceFromRid(Long roleId);

    ResourceEntity findResourceCustomizeById(Long id);
}
