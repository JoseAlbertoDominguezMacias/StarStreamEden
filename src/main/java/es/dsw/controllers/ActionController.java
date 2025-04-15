package es.dsw.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.dsw.models.Rol;
import es.dsw.models.Usuario;
import es.dsw.services.ServicioRol;
import es.dsw.services.ServicioUsuario;
import jakarta.servlet.http.HttpSession;

@Controller
public class ActionController {
	
	private final ServicioUsuario servicioUsuario;
	private final ServicioRol servicioRol;

    // Constructor con inyección de dependencias
    public ActionController(ServicioUsuario servicioUsuario, ServicioRol servicioRol) {
        this.servicioUsuario = servicioUsuario;
        this.servicioRol = servicioRol;
    }

	    @GetMapping({"/", "/index"})
	    public String showIndex() {
	        return "index"; 
	    }

	    @GetMapping("/register")
	    public String showRegisterPage() {
	        return "register"; 
	    }

	    @GetMapping("/login")
	    public String showLoginPage() {
	        return "login";
	    }

	    @GetMapping("/juego")
	    public String showJuego(Model model) {
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
	            }
	            if (usuario != null) {
	                model.addAttribute("alias", usuario.getAlias());
	                model.addAttribute("flota", usuario.getFlota());

	                // Si el usuario no tiene flota asignada, mostramos los planetas para elegir
	                if (usuario.getFlota() == null) {
	                    List<String> planetas = List.of("La Tierra", "Júpiter", "Lobo V");
	                    model.addAttribute("planetas", planetas);
	                    return "seleccionarPlaneta"; // Nueva vista donde elige su planeta
	                }
	            }
	        }

	        return "juego"; // Redirige al juego si ya tiene flota
	    
	    }
	    
	   /* @GetMapping("/home")
	    public String home(Model model, Authentication authentication) {
	        model.addAttribute("username", authentication.getName());
	        return "home";
	    }*/

	    @GetMapping("/admin/home")
	    public String adminHome(Model model, Authentication authentication) {
	        model.addAttribute("username", authentication.getName());
	        return "adminHome";
	    }
	    
	    @GetMapping("/admin")
	    public String mostrarPanelAdmin(Model model) {
	        List<Usuario> usuarios = servicioUsuario.findAll();
	        List<String> mensajesUsuarios = new ArrayList<>();  // Mensajes sin nombres
	        List<String> nombresUsuarios = new ArrayList<>();   // Solo los nombres

	     // Generar los reportes
	        for (Usuario usuario : usuarios) {
	            mensajesUsuarios.add("Se ha registrado el usuario"); // Mensaje fijo
	            Rol rol = servicioRol.obtenerRolPorId(usuario.getRolId());  // Obtener el objeto Rol

	            // Aplicar estilo al alias (color aleatorio) y al rol (blanco, cursiva y negrita)
	            String aliasEstilizado = "<" +"<span style='color: " + getColorAleatorio() + ";'>" + usuario.getAlias() + "</span>" + ">";
	            
	            // La frase "con el Rol :" será siempre blanca (sin heredar color)
	            String fraseRol = "<span style='color: white;'> con el Rol : </span>";
	            
	            // El rol tendrá el estilo blanco, cursiva y negrita
	            String rolEstilizado = "<span style='color: white; font-style: italic; font-weight: bold;'>" + (rol != null ? rol.getNombre() : "Sin Rol") + "</span>";
	            
	            // Aquí combinamos los tres componentes (alias, frase y rol)
	            nombresUsuarios.add(aliasEstilizado + fraseRol + rolEstilizado);
	        }




	        model.addAttribute("mensajesUsuarios", mensajesUsuarios);
	        model.addAttribute("nombresUsuarios", nombresUsuarios);

	        return "admin";
	    }
	    
	 // Función para obtener un color aleatorio
	    private String getColorAleatorio() {
	        List<String> colores = List.of("#FF5733", "#33FF57", "#3357FF", "#F4C842", "#8E44AD");
	        return colores.get((int) (Math.random() * colores.size()));
	    }

	    @PostMapping("/asignarFlota")
	    public String asignarFlota(@RequestParam("planeta") String planeta, Model model) {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        
	        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
	            String alias = authentication.getName();
	            Usuario usuario = servicioUsuario.findByAlias(alias);

	            if (usuario != null) {
	                // Buscar una flota disponible (Ejemplo: asignar una flota existente)
	                Long idFlotaAsignada = servicioUsuario.asignarFlotaPorPlaneta(planeta);
	                usuario.setFlota(idFlotaAsignada);
	                servicioUsuario.save(usuario);
	            }
	        }

	        return "redirect:/juego"; // Ahora el usuario puede jugar
	    }
	    
	    /*
	    @PostMapping("/login")
	    public String processLogin(@RequestParam String alias, @RequestParam String contraseña, Model model) {
	        if ("admin".equals(alias) && "1234".equals(contraseña)) {
	            model.addAttribute("alias", alias);
	            return "home"; 
	        } else {
	            return "redirect:/login?error=true";
	        }
	    }*/
	    
	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate(); // Invalida la sesión y borra todos los datos
	        return "redirect:/index"; // Redirige al usuario a la página de login
	    }
	}