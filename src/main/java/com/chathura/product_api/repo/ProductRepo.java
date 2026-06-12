package com.chathura.product_api.repo;

import com.chathura.product_api.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM products WHERE name LIKE  %?1% OR description LIKE  %?1%",
            nativeQuery = true)
    public Page<Product> searchAllProduct(String searchText, Pageable pageable);
}