package com.sandbox.hibernate.repository;

import com.sandbox.hibernate.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<Product, Long> {
}
