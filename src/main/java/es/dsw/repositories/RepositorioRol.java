package es.dsw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.dsw.models.Rol;


@Repository
public interface RepositorioRol extends JpaRepository<Rol, Long> {
	

	
}
