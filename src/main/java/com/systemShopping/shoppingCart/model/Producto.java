package com.systemShopping.shoppingCart.model;


import java.util.ArrayList;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


// Identifica cual es el dominio del Objeto en la Coleccion de MongoDb
@Document(collection = "producto")

@Entity //Especifica que la clase es una entidad / coleccion JPA
@Data   // Genera Getters y Setters
public class Producto {

    // Identificador de la coleccion
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  La BD asigna automaticamente el valor del identificador JPA 
    private String id;

    private String nombre_producto;
    private String descripcion;
    private int precio_unitario;
    private int cantidad;

    // Especifica la exitencia de una anidacion de colecciones
   @Embedded
   private ArrayList <String> fotos;
}