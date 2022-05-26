package com.gapache.cloud.auth.server.dao.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "tb_user_client_relation")
public class UserClientRelationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "client_id", nullable = false)
    private Long clientId;
}
