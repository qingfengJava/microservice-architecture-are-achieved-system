package com.gapache.jpa;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;

@NoRepositoryBean
public abstract class BaseJpaRepositoryBean<T, ID> extends SimpleJpaRepository<T, ID> {

    protected final EntityManager em;

    public BaseJpaRepositoryBean(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") Class<T> tClass, EntityManager entityManager) {
        super(tClass, entityManager);
        em = entityManager;
    }
}
