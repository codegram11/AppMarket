package com.pixaica.platzimarketv2.persistence;

import com.pixaica.platzimarketv2.domain.Purchase;
import com.pixaica.platzimarketv2.domain.repository.PurchaseRepository;
import com.pixaica.platzimarketv2.persistence.crud.CompraCrudRepositorio;
import com.pixaica.platzimarketv2.persistence.entity.Compra;
import com.pixaica.platzimarketv2.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepositorio implements PurchaseRepository {

    @Autowired
    private CompraCrudRepositorio compraCrudRepositorio;


    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepositorio.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepositorio.findByIdCliente(clientId).map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductoCompras().forEach(producto -> producto.setCompra(compra));
        return mapper.toPurchase(compraCrudRepositorio.save(compra));
    }
}
