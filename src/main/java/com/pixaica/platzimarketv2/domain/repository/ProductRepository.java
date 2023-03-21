package com.pixaica.platzimarketv2.domain.repository;

import com.pixaica.platzimarketv2.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> getAll();

    Optional<List<Product>> getByCategory(int idCategory);

    Optional<List<Product>> getScarseProduct(int quantity);

    Optional<Product> getProduct(int productId);

    Product save(Product product);

    void delete(int productId);
}
