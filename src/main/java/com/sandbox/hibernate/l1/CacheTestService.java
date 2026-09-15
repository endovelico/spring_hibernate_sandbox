package com.sandbox.hibernate.l1;

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
    public void testL1() {

        System.out.println("========== L1 TEST ==========");

        System.out.println("First lookup:");

        Product product1 =
                entityManager.find(Product.class, 1L);

        System.out.println(
                "Product: " + product1.getName()
        );


        System.out.println("Second lookup:");

        Product product2 =
                entityManager.find(Product.class, 1L);

        System.out.println(
                "Product: " + product2.getName()
        );


        System.out.println(
                "Same Java object? "
                        + (product1 == product2)
        );
    }
}