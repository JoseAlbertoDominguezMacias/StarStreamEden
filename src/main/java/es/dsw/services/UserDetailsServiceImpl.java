package es.dsw.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import es.dsw.models.Rol;
import es.dsw.models.Usuario;
import es.dsw.repositories.RepositorioRol;
import es.dsw.repositories.RepositorioUsuario;

import java.util.HashSet;
import java.util.Set;


public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    private RepositorioRol repositorioRol; // Inyectamos el repositorio de roles
    
    @Override
    public UserDetails loadUserByUsername(String alias) throws UsernameNotFoundException {
        // Buscar el usuario en la base de datos por su alias
        Usuario usuario = repositorioUsuario.findByAlias(alias);

        if (usuario == null) {
        	System.out.println("Usuario no encontrado, es nulo");
            throw new UsernameNotFoundException("Usuario no encontrado: " + alias);
        }

        // Crear un conjunto de roles para este usuario
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        
        // Obtener el rol del usuario
     // Buscar el objeto Rol a partir del ID
        Rol rol = repositorioRol.findById(usuario.getRolId()).orElse(null);
        if (rol != null) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + rol.getNombre()));
        }

        // Crear un objeto User (de Spring Security) con el alias, la contraseña y los roles
        User u = new User(usuario.getAlias(), usuario.getContraseña(), grantedAuthorities);
        System.out.println("Las authirities son: ");
        System.out.println(u.getAuthorities().toString());
        return u;
    }
}


