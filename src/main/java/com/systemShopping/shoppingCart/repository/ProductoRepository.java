package com.systemShopping.shoppingCart.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.systemShopping.shoppingCart.model.Producto;


@Repository
public interface ProductoRepository extends MongoRepository <Producto,String>{
    
}
