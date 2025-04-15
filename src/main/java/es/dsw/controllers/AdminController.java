package es.dsw.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import es.dsw.models.Flota;
import es.dsw.models.Mision;
import es.dsw.models.Tripulacion;
import es.dsw.models.Usuario;
import es.dsw.services.ServicioFlota;
import es.dsw.services.ServicioMision;
import es.dsw.services.ServicioTripulacion;
import es.dsw.services.ServicioUsuario;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ServicioUsuario servicioUsuario;
    private final ServicioFlota servicioFlota;
    private final ServicioTripulacion servicioTripulacion;
    private final ServicioMision servicioMision;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminController(ServicioUsuario servicioUsuario, ServicioFlota servicioFlota, 
                           ServicioTripulacion servicioTripulacion,ServicioMision servicioMision, PasswordEncoder passwordEncoder) {
        this.servicioUsuario = servicioUsuario;
        this.servicioFlota = servicioFlota;
        this.servicioTripulacion = servicioTripulacion;
        this.servicioMision = servicioMision;
        this.passwordEncoder = passwordEncoder;
    }
    

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = servicioUsuario.findAll();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("usuarioNuevo", new Usuario());
        return "usuarios";
    }

    @PostMapping("/usuarios/agregar")
    public String agregarUsuario(@ModelAttribute Usuario usuario) { 
        servicioUsuario.save(usuario);
        return "redirect:/admin/usuarios";
    }

    @PostMapping("/usuarios/editar/{id}")
    public String actualizarUsuario(@PathVariable Long id, @ModelAttribute Usuario usuario) {
        Usuario usuarioExistente = servicioUsuario.findById(id);
        if (usuarioExistente != null) {
            usuarioExistente.setAlias(usuario.getAlias());
            usuarioExistente.setEmail(usuario.getEmail());
            usuarioExistente.setRolId(usuario.getRolId());
            usuarioExistente.setFlota(usuario.getFlota());
            servicioUsuario.save(usuarioExistente);
        }
        return "redirect:/admin/usuarios";
    }

    @PostMapping("/usuarios/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        servicioUsuario.deleteById(id);
        return "redirect:/admin/usuarios";
    }
    

    @GetMapping("/flotas")
    public String listarFlotas(Model model) {
        List<Flota> flotas = servicioFlota.findAll();
        model.addAttribute("flotas", flotas);
        model.addAttribute("flotaNuevo", new Flota());
        return "/flotas";
    }

    @PostMapping("/flotas/agregar")
    public String agregarFlota(@ModelAttribute Flota flota) {
        flota.setId(flota.getId());
        flota.setNombre(flota.getNombre());
        flota.setBase(flota.getBase());
        servicioFlota.save(flota);
        return "redirect:/admin/flotas";
    }

    @PostMapping("/flotas/editar/{id}")
    public String actualizarFlotas(@PathVariable Long id, @ModelAttribute Flota flota) {
        Flota flotaExistente = servicioFlota.findById(id);
        if (flotaExistente != null) {
            flotaExistente.setId(flota.getId());
            flotaExistente.setNombre(flota.getNombre());
            flotaExistente.setBase(flota.getBase());
            servicioFlota.save(flotaExistente);
        }
        return "redirect:/admin/flotas";
    }

    @PostMapping("/flotas/eliminar/{id}")
    public String eliminarFlotas(@PathVariable Long id) {
        servicioFlota.deleteById(id);
        return "redirect:/admin/flotas";
    }
    
    @GetMapping("/tripulaciones")
    public String listarTripulaciones(Model model) {
        List<Tripulacion> tripulaciones = servicioTripulacion.findAll();
        model.addAttribute("tripulaciones", tripulaciones);
        model.addAttribute("tripulacionNuevo", new Tripulacion());
        return "/tripulaciones";
    }
    
    @PostMapping("/tripulaciones/agregar")
    public String agregarTripulacion(@ModelAttribute Tripulacion tripulacion) {
    	 // Verifica si el idFlota está presente
        if (tripulacion.getIdFlota() != null && tripulacion.getIdFlota().getId() != null) {
            // Recupera la Flota a partir del idFlota enviado en el formulario
            Flota flota = servicioFlota.findById(tripulacion.getIdFlota().getId());
            if (flota != null) {
                tripulacion.setIdFlota(flota);  // Asigna la Flota a la Tripulacion
            }
        }
        tripulacion.setId(tripulacion.getId());
        tripulacion.setNombre(tripulacion.getNombre());
        tripulacion.setRolEnFlota(tripulacion.getRolEnFlota());
        servicioTripulacion.save(tripulacion);
        return "redirect:/admin/tripulaciones";
    }

    @PostMapping("/tripulaciones/editar/{id}")
    public String actualizarTripulaciones(@PathVariable Long id, @ModelAttribute Tripulacion tripulacion) {
        Tripulacion tripulacionExistente = servicioTripulacion.findById(id);
        if (tripulacionExistente != null) {
        	tripulacionExistente.setId(tripulacion.getId());
        	tripulacionExistente.setIdFlota(tripulacion.getIdFlota());
        	tripulacionExistente.setNombre(tripulacion.getNombre());
        	tripulacionExistente.setRolEnFlota(tripulacion.getRolEnFlota());
            servicioTripulacion.save(tripulacionExistente);
        }
        return "redirect:/admin/tripulaciones";
    }

    @PostMapping("/tripulaciones/eliminar/{id}")
    public String eliminarTripulaciones(@PathVariable Long id) {
        servicioTripulacion.deleteById(id);
        return "redirect:/admin/tripulaciones";
    }
    
    @GetMapping("/misiones")
    public String listarMisiones(Model model) {
        List<Mision> misiones = servicioMision.findAll();
        model.addAttribute("misiones", misiones);
        model.addAttribute("misionNuevo", new Mision());
        return "/misiones";
    }
    
    @PostMapping("/misiones/agregar")
    public String agregarMision(@ModelAttribute Mision mision) {
        mision.setIdMision(mision.getIdMision());
        mision.setTitulo(mision.getTitulo());
        mision.setDescripcion(mision.getDescripcion());
        servicioMision.save(mision);
        return "redirect:/admin/misiones";
    }

    @PostMapping("/misiones/editar/{id}")
    public String actualizarMisiones(@PathVariable Long id, @ModelAttribute Mision mision) {
        Mision misionExistente = servicioMision.findById(id);
        if (misionExistente != null) {
        	misionExistente.setIdMision(mision.getIdMision());
        	misionExistente.setTitulo(mision.getTitulo());
        	misionExistente.setDescripcion(mision.getDescripcion());
            servicioMision.save(misionExistente);
        }
        return "redirect:/admin/misiones";
    }

    @PostMapping("/misiones/eliminar/{id}")
    public String eliminarMisiones(@PathVariable Long id) {
        servicioMision.deleteById(id);
        return "redirect:/admin/misiones";
    }
  
    
    @PostMapping("/enviarMensaje")
    public String enviarMensaje(@RequestParam("mensaje") String mensaje) {
    // Aquí podrías implementar la lógica para enviar el mensaje a todos los usuarios
    	System.out.println("Mensaje enviado a todos los usuarios: " + mensaje);
    	return "redirect:/admin";
    }
}

