package com.gapache.cloud.auth.server.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_in_stock")
public class InStockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "goods_id")
    private Long goodsId;

    @Column(name = "stock")
    private Long stock;
}
