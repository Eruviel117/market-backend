package mx.edu.tecdesoftware.market_backend.domain.repository;

import mx.edu.tecdesoftware.market_backend.domain.Purchase;

import java.util.List;

public interface PurchaseRepository {
    List<Purchase> getAll();
    List<Purchase> getByClientId(String clientId);
    Purchase save(Purchase purchase);
}