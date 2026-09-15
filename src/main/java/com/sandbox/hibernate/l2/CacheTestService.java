package com.sandbox.hibernate.l2;

import com.sandbox.hibernate.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CacheTestService {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public void firstTransaction() {

        System.out.println("===== TRANSACTION 1 =====");

        Product product =
                entityManager.find(Product.class, 1L);

        System.out.println(product.getName());
    }


    @Transactional
    public void secondTransaction() {

        System.out.println("===== TRANSACTION 2 =====");

        Product product =
                entityManager.find(Product.class, 1L);

        System.out.println(product.getName());
    }
}