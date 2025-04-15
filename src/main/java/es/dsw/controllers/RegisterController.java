package es.dsw.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import es.dsw.models.Rol;
import es.dsw.models.Usuario;
import es.dsw.services.ServicioUsuario;

@Controller
public class RegisterController {
	// Agregar una lista para almacenar reportes en memoria
	private static List<String> reportesUsuarios = new ArrayList<>();

    private final ServicioUsuario servicioUsuario;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterController(ServicioUsuario servicioUsuario, PasswordEncoder passwordEncoder) {
        this.servicioUsuario = servicioUsuario;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String register(Usuario usuario, Model model) {
        // Verificar si el alias ya existe en la base de datos
        if (servicioUsuario.findByAlias(usuario.getAlias()) != null) {
            model.addAttribute("message", "Error: El alias ya está en uso.");
            return "register"; // Regresa a la página de registro con el mensaje de error
        }
        
     // Obtener el rol "user" (id = 1)
        Rol rolUsuario = servicioUsuario.obtenerRolPorId(3L); // Asegúrate de que el rol con ID 1 exista en la BD
        
        if (rolUsuario == null) {
            model.addAttribute("message", "Error: No se encontró el rol de usuario.");
            return "register";
        }

        // Asignar el rol al usuario
        usuario.setRolId(rolUsuario.getIdRol());
        
        // Guardar el nuevo usuario en la base de datos
        servicioUsuario.save(usuario);
        
        // Agregar mensaje de éxito al modelo
        model.addAttribute("message", "Usuario registrado exitosamente.");
        
        return "redirect:/register"; // Redirigir al login después de un registro exitoso
    }
    
    
}
