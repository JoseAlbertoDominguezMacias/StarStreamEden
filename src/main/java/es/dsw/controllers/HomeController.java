package es.dsw.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;

import es.dsw.models.Rol;
import es.dsw.models.Usuario;
import es.dsw.services.ServicioUsuario;

@Controller
public class HomeController {

    private final ServicioUsuario servicioUsuario;

    public HomeController(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @GetMapping("/home")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String alias = userDetails.getUsername();  // Obtener el alias

            // Buscar al usuario en la base de datos
            Usuario usuario = servicioUsuario.findByAlias(alias);

            if (usuario != null && usuario.getRolId() != null) { // Asegurar que rol no sea null
                Rol rol = servicioUsuario.obtenerRolPorId(usuario.getRolId()); // Obtener el objeto Rol
                model.addAttribute("alias", usuario.getAlias());
                model.addAttribute("rol", rol != null ? rol.getNombre() : "Sin Rol");
            } else {
                model.addAttribute("alias", "Desconocido");
                model.addAttribute("rol", "Sin Rol");
            }}

        return "home"; // Asegurar que siempre se retorna un String
    }
    
}
