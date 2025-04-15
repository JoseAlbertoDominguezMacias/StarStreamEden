package es.dsw.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dsw.models.Flota;
import es.dsw.models.Mision;
import es.dsw.repositories.RepositorioMision;

@Service
public class ServicioMision {

	
	    @Autowired
	    private RepositorioMision repositorioMision;

	    public Mision findByTitulo(String titulo) {
	        return repositorioMision.findByTitulo(titulo);
	    }

		public void save(Mision mision) {
	        repositorioMision.save(mision);
	    }
	    
		 // Listar todas las misiones
	    public List<Mision> findAll() {
	        return repositorioMision.findAll();
	    }
		 // Buscar un usuario por ID
	    public Mision findById(Long id_mision) {
	        Optional<Mision> mision = repositorioMision.findById(id_mision);
	        return mision.orElse(null); // Si no encuentra el usuario, devuelve null
	    }

	    // Eliminar usuario por ID
	    public void deleteById(Long id_mision) {
	        repositorioMision.deleteById(id_mision);
	    }

	    public long countFlotas() {
	        return repositorioMision.countFlotas(); // Suponiendo que `flota` está en `Usuario`
	    }
	}

