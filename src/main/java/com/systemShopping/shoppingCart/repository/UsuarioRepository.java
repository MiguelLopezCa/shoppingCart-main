package com.systemShopping.shoppingCart.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.systemShopping.shoppingCart.model.Usuario;


@Repository
public interface UsuarioRepository extends MongoRepository <Usuario,String>{
 
    public Usuario findByUsuarioAndContrasena(String usuario, String contrasena);
    public Usuario findByUsuario(String usuario);
}
