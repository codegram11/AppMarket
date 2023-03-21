package com.pixaica.platzimarketv2.persistence;

import com.pixaica.platzimarketv2.domain.Product;
import com.pixaica.platzimarketv2.domain.repository.ProductRepository;
import com.pixaica.platzimarketv2.persistence.crud.ProductoCrudRepositorio;
import com.pixaica.platzimarketv2.persistence.entity.Producto;
import com.pixaica.platzimarketv2.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepositorio implements ProductRepository {

    @Autowired
    private ProductoCrudRepositorio repositorio;

    @Autowired
    private ProductMapper mapper;



    @Override
    public List<Product> getAll(){
        List<Producto> productos= (List<Producto>) repositorio.findAll();
        return mapper.toProductList(productos);
    }

    @Override
    public void delete(int idProducto){repositorio.deleteById(idProducto);}

    @Override
    public Optional<List<Product>> getByCategory(int idCategory) {
        List<Producto> productos= repositorio.findByIdCategoriaOrderByNombreAsc(idCategory);
        return Optional.of(mapper.toProductList(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProduct(int quantity) {
        Optional<List<Producto>> productoList=repositorio.findByCantidadStockLessThanAndEstado(quantity, true);
        return productoList.map(prods-> mapper.toProductList(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
       return repositorio.findById(productId).map(prods -> mapper.toProduct(prods));
    }

    @Override
    public Product save(Product product) {
        return mapper.toProduct(repositorio.save(mapper.toProducto(product)));
    }

}
