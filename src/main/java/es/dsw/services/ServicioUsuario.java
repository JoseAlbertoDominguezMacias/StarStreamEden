package es.dsw.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dsw.models.Rol;
import es.dsw.models.Usuario;
import es.dsw.repositories.RepositorioRol;
import es.dsw.repositories.RepositorioUsuario;

@Service
public class ServicioUsuario {
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	private RepositorioRol repositorioRol;
	
	 public ServicioUsuario(RepositorioUsuario repositorioUsuario, RepositorioRol repositorioRol) {
	        this.repositorioUsuario = repositorioUsuario;
	        this.repositorioRol = repositorioRol;
	    }
	public Usuario obtenerUsuarioPorAlias(String alias) {
		return this.repositorioUsuario.findByAlias(alias);
	}

	public List<Usuario> obtenerUsuarios() {
		 List<Usuario> usuarios = new ArrayList<>();
	     for (Usuario u : this.repositorioUsuario.findAll()) {
	    	 usuarios.add(u);
	     }
	     
	     return usuarios;
	}
	// Función para obtener un color aleatorio
	private String getColorAleatorio() {
	    List<String> colores = List.of("#FF5733", "#33FF57", "#3357FF", "#F4C842", "#8E44AD");
	    return colores.get((int) (Math.random() * colores.size()));
	}
	
	public Usuario findByAlias(String alias) {
        return repositorioUsuario.findByAlias(alias);
    }

	public Rol obtenerRolPorId(Long rolId) {
	    return repositorioRol.findById(rolId).orElse(null);
	}
	
	public void save(Usuario usuario) {
        repositorioUsuario.save(usuario);
    }
	
	 // Listar todos los usuarios
    public List<Usuario> findAll() {
        return repositorioUsuario.findAll();
    }
	 // Buscar un usuario por ID
    public Usuario findById(Long id) {
        Optional<Usuario> usuario = repositorioUsuario.findById(id);
        return usuario.orElse(null); // Si no encuentra el usuario, devuelve null
    }

    // Eliminar usuario por ID
    public void deleteById(Long id) {
        repositorioUsuario.deleteById(id);
    }
    public long countUsuarios() {
        return repositorioUsuario.count(); // Devuelve el total de usuarios
    }
    public Long asignarFlotaPorPlaneta(String planeta) {
        // Simulamos la asignación de flotas con IDs
        Map<String, Long> flotasPorPlaneta = Map.of(
            "La Tierra", 1L,
            "Júpiter", 2L,
            "Lobo V", 3L
        );

        return flotasPorPlaneta.getOrDefault(planeta, 1L); // Si el planeta no está, asigna la flota 1
    }
}



