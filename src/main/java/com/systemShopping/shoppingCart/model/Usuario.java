package com.systemShopping.shoppingCart.model;


import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

// Identifica cual es el dominio del Objeto en la Coleccion de MongoDb
@Document(collection = "usuario") 
@Data    //Genera Getters y Setters Automaticamente 
@Entity  // Especifica que la clase en una entidad JPA
public class Usuario {
    
    // Especifica el identificador de la identidad
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La BD Asigna automaticamente el valor del identificador JPA 
    private String id;
  
    private String nombre;
    private String usuario;
    private String contrasena;
    private String direccion;
    private String ciudad;
    private String departamento;
    private String telefono;
    private String correo;

}
