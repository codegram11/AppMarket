package com.pixaica.platzimarketv2.persistence.crud;

import com.pixaica.platzimarketv2.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepositorio extends CrudRepository<Producto, Integer> {

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int catidadStock, boolean estado);
}
