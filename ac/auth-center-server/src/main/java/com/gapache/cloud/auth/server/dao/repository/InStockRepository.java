package com.gapache.cloud.auth.server.dao.repository;

import com.gapache.cloud.auth.server.dao.entity.InStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InStockRepository extends JpaRepository<InStockEntity, Long> {

}
