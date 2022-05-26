package com.gapache.user.server.dao.repository;

import com.gapache.user.server.dao.entity.UserRelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRelationRepository extends JpaRepository<UserRelationEntity, Long> {

    boolean existsByOwnerIdAndUserId(Long ownerId, Long userId);

    void deleteAllByOwnerIdInAndUserId(Iterable<Long> ownerIds, Long userId);

    void deleteAllByUserId(Long userId);
}
