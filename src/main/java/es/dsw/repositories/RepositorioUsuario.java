package es.dsw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.dsw.models.Usuario;


@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
	
	Usuario findByAlias(String alias);
	
	 	@Query("SELECT COUNT(u) FROM Usuario u")
	    long countUsuarios();

}

