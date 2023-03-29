package com.systemShopping.shoppingCart.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.systemShopping.shoppingCart.model.Producto;
import com.systemShopping.shoppingCart.service.ProductoService;
import lombok.RequiredArgsConstructor;


@RestController // Marca como controlador la Clase Producto Controller
@RequestMapping("/producto") // Mapeo de la ruta General
@RequiredArgsConstructor
public class ProductoController {
    
    @Autowired
    private  ProductoService productoService;
    
    // Servicio - Genera un listado de todos los productos de la BD
    @GetMapping("/getAllProducto")
    public List<Producto> obtenerAllProducto() {
        return productoService.obtenerAllProducto(); // Trae la lista completa de productos
    }

    // Servicio - Genera una lista aletoria de Productos de la BD
    @GetMapping("/getRandomProducto")
    public ResponseEntity<List<Producto>> getRandomProducts() {

        List<Producto> productos = productoService.obtenerAllProducto(); // Trae la lista total de los productos
        
        int cont = new Random().nextInt(8) + 2; // Genera un numero aleatorio entre 2 y 10
        
        List<Producto> randomProducts = new ArrayList<>(); // Crea una lista tipo producto (Almacena los productos Random)
        
        for (int i = 0; i < cont; i++) { // Mientas que i sea menor al numero de elementos

            int randomIndex = new Random().nextInt(productos.size()); // Genera un indice para acceder a la informacion de un producto
            randomProducts.add(productos.get(randomIndex)); // Anade a la lista productos traidos en base al indice generedo aleatoriamente

        }
        return ResponseEntity.ok(randomProducts); // Devuelve la lista de productos Randoms
    }

    // Servicio - Actualiza la cantidad del producto
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarProducto(@PathVariable String id, @RequestParam int cantidadVent) {
        
        Optional<Producto> opProducto = productoService.obtenerProductoId(id); // Traer el producto por Id
        
        if (opProducto.isPresent()) { // Verifica si el producto esta presente en la list / Optional
            
            Producto producto = opProducto.get(); // Trae los valores de producto
            int cantidadDisponible = producto.getCantidad(); // Trae el valor de la cantidad
            
            if (cantidadDisponible >= cantidadVent) { // Valida si la cantidad Disponible es mayor a la de venta
                
                producto.setCantidad(cantidadDisponible - cantidadVent); // Asigna la nueva cantidad al producto
                productoService.save(producto); // Utiliza el microservicio Save para guardar / actualizar los datos

                return ResponseEntity.ok("Cantidad Disponible");
            
            } else {

                return ResponseEntity.badRequest().body("No hay suficiente cantidad");
            }

        } else {

            return ResponseEntity.notFound().build();
        
        }
    }
    
}

