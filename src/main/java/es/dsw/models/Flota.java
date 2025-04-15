package es.dsw.models;

import jakarta.persistence.*;

@Entity
@Table(name = "flota")
public class Flota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_flota")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "base")
    private String base;


    public Flota(Long id, String nombre, String base) {
        this.id = id;
        this.nombre = nombre;
        this.base = base;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

	public Flota() {
		super();
	}


    
}
