package com.systemShopping.shoppingCart.controller;


import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.systemShopping.shoppingCart.model.Usuario;
import com.systemShopping.shoppingCart.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    
    // Traer todos los Usuarios 
    @GetMapping("/getAllUsuarios")
    public List<Usuario> obtenerUsuario(){
        return usuarioService.obtenerUsuario();
    } 

    // Validar Credenciales del Usuario (BOOLEAN)
    @PostMapping("/login")
    public ResponseEntity<?> iniciarSesion(@RequestBody Map<String, String> credenciales){

        String nombreUsuario = credenciales.get("nombreUsuario");
        String contrasena = credenciales.get("contrasena");

        boolean credencialesCorrectas = usuarioService.validarCredenciales(nombreUsuario, contrasena); // Trae el valor si el usuario es valido -- Invoca el servicio de Validar Usuario

        if(credencialesCorrectas){ 
            
            // Datos de inicio de sesion correctos 

            Usuario usuario = usuarioService.traerUsuario(nombreUsuario); // Utiliza el servicio de traer objeto <Usuario> - Trae los datos del usuario Valido
            
            return ResponseEntity.ok(usuario); // Devuelve un objeto <Usuario>
        }else{

            // Datos de inicio de sesion Incorrectos 

            return ResponseEntity.ok(false); // Devuleve un valor Boolean de False
        }
    }    
}
