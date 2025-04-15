package es.dsw.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dsw.models.Rol;
import es.dsw.models.Usuario;
import es.dsw.repositories.RepositorioRol;
import es.dsw.repositories.RepositorioUsuario;

@Service
public class ServicioRol {

	@Autowired
	private RepositorioRol repositorioRol;
	

	public List<Rol> obtenerUsuarios() {
		 List<Rol> roles = new ArrayList<>();
	     for (Rol r : this.repositorioRol.findAll()) {
	    	 roles.add(r);
	     }
	     
	     return roles;
	}

	public Rol obtenerRolPorId(Long rolId) {
	    return repositorioRol.findById(rolId).orElse(null);
	}}
