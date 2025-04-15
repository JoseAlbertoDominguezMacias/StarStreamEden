package es.dsw.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.dsw.models.Flota;
import es.dsw.models.Mision;

public interface RepositorioMision extends JpaRepository<Mision, Long> {
		
		List<Mision> findAll();
	
		Mision findByTitulo(String titulo);
	
	    @Query("SELECT COUNT(f) FROM Flota f")
	    long countFlotas();

}
	

