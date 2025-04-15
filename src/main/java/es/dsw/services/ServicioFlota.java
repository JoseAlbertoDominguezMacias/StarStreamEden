package es.dsw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.dsw.models.Flota;
import es.dsw.models.Rol;
import es.dsw.models.Usuario;
import es.dsw.repositories.RepositorioFlota;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioFlota {

    @Autowired
    private RepositorioFlota repositorioFlota;

    public Flota findByNombre(String nombre) {
        return repositorioFlota.findByNombre(nombre);
    }

	public void save(Flota flota) {
        repositorioFlota.save(flota);
    }
    
	 // Listar todos los usuarios
    public List<Flota> findAll() {
        return repositorioFlota.findAll();
    }
	 // Buscar un usuario por ID
    public Flota findById(Long id) {
        Optional<Flota> flota = repositorioFlota.findById(id);
        return flota.orElse(null); // Si no encuentra el usuario, devuelve null
    }

    // Eliminar usuario por ID
    public void deleteById(Long id) {
        repositorioFlota.deleteById(id);
    }

    public long countFlotas() {
        return repositorioFlota.countFlotas(); // Suponiendo que `flota` está en `Usuario`
    }
}