package com.gapache.cloud.auth.server.dao.repository.client;

import com.gapache.cloud.auth.server.dao.entity.ClientEntity;
import com.gapache.jpa.BaseJpaRepository;

public interface ClientRepository extends BaseJpaRepository<ClientEntity, Long> {

    ClientEntity findByClientId(String clientId);

    Boolean existsByClientId(String clientId);
}
