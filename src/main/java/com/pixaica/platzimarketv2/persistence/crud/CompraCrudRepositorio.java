package com.pixaica.platzimarketv2.persistence.crud;

import com.pixaica.platzimarketv2.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepositorio extends CrudRepository<Compra, Integer> {


    Optional<List<Compra>> findByIdCliente(String idCliente);
}
