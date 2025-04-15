package es.dsw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dsw.models.Flota;
import es.dsw.models.Tripulacion;
import es.dsw.repositories.RepositorioFlota;
import es.dsw.repositories.RepositorioTripulacion;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioTripulacion {

    @Autowired
    private RepositorioTripulacion repositorioTripulacion;

    public Flota findByNombre(String nombre) {
        return repositorioTripulacion.findByNombre(nombre);
    }

	public void save(Tripulacion tripulacion) {
        repositorioTripulacion.save(tripulacion);
    }
    
	 // Listar todos los usuarios
    public List<Tripulacion> findAll() {
        return repositorioTripulacion.findAll();
    }
	 // Buscar un usuario por ID
    public Tripulacion findById(Long idTripulacion) {
        Optional<Tripulacion> tripulacion = repositorioTripulacion.findById(idTripulacion);
        return tripulacion.orElse(null); // Si no encuentra el usuario, devuelve null
    }

    // Eliminar usuario por ID
    public void deleteById(Long idTripulacion) {
        repositorioTripulacion.deleteById(idTripulacion);
    }

    public long countTripulaciones() {
        return repositorioTripulacion.countTripulaciones(); 
    }
}