package es.dsw.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.dsw.models.Flota;
import es.dsw.models.Usuario;

public interface RepositorioFlota extends JpaRepository<Flota, Long> {
	
		List<Flota> findAll();
	
		Flota findByNombre(String nombre);
	
	    @Query("SELECT COUNT(f) FROM Flota f")
	    long countFlotas();

}