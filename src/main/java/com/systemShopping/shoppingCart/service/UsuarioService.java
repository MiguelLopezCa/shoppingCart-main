package com.systemShopping.shoppingCart.service;


import java.util.List;
import org.springframework.stereotype.Service;
import com.systemShopping.shoppingCart.model.Usuario;
import com.systemShopping.shoppingCart.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;


// Especifica que ProductoService es un bean de Servicios de Spring
@Service
@RequiredArgsConstructor
public class UsuarioService {
    
    private final UsuarioRepository usuarioRepository;

    // Servicio Obtener Productos
    public List<Usuario> obtenerUsuario(){
        // Trae la info de todos los productos 
        List<Usuario> usuario = usuarioRepository.findAll();
        // Retorna el la lista de productos 
        return usuario;
    }

    // Validar Credenciales del Usuario 
    public boolean validarCredenciales(String nombreUsuario, String contrasena){
        Usuario usuario = usuarioRepository.findByUsuarioAndContrasena(nombreUsuario, contrasena);
        return usuario != null;
    }

    // Trae los datos del usuario
    public Usuario traerUsuario(String nUsuario) {
        Usuario usuario = usuarioRepository.findByUsuario(nUsuario);
        return usuario;
    }
}
