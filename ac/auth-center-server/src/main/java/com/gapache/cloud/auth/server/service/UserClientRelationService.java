package com.gapache.cloud.auth.server.service;

import com.gapache.cloud.auth.server.model.UserClientRelationDTO;

public interface UserClientRelationService {

    UserClientRelationDTO findByUserIdAndClientId(Long userId, Long clientId);

    Boolean create(UserClientRelationDTO userClientRelationDTO);
}
