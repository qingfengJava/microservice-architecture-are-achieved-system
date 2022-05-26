package com.gapache.user.server.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_no", nullable = false, unique = true)
    private String orderNo;
}
