package com.pixaica.platzimarketv2.domain.repository;

import com.pixaica.platzimarketv2.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase> getAll();

    Optional<List<Purchase>> getByClient(String clientId);

    Purchase save(Purchase purchase);
}
