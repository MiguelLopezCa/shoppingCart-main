package com.systemShopping.shoppingCart.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.systemShopping.shoppingCart.model.Producto;
import com.systemShopping.shoppingCart.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;


// Especifica que ProductoService es un bean de Servicios de Spring
@Service 
@RequiredArgsConstructor
public class ProductoService {
    
    // Instancia ProductoRepository en ProductoService
    @Autowired 
    private  ProductoRepository productoRepository;

    // Trae la info de todos los productos
    public List<Producto> obtenerAllProducto(){
        List<Producto> productos = productoRepository.findAll();
        return productos;
    }

    // Trae la info  de un producto por Id
    public Optional<Producto> obtenerProductoId (String id) {
        Optional<Producto> producto = productoRepository.findById(id);
        return producto;
    }

    // Guarda info del producto
    public void save (Producto producto){
        productoRepository.save(producto);
    }    
}
