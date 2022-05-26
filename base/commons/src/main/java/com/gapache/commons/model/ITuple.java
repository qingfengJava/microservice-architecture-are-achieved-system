package com.gapache.commons.model;

import lombok.Data;

@Data
public class ITuple<L, R> {
    private L left;
    private R right;
}
