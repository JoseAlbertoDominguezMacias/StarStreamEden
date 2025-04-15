package es.dsw.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.dsw.models.Flota;
import es.dsw.models.Tripulacion;

public interface RepositorioTripulacion extends JpaRepository<Tripulacion, Long> {

	
	List<Tripulacion> findAll();
	
	Flota findByNombre(String nombre);
	
	
    @Query("SELECT COUNT(t) FROM Tripulacion t")
    long countTripulaciones();
}
