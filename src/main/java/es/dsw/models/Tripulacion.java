package es.dsw.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tripulacion")
public class Tripulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tripulacion")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_flota")
    private Flota idFlota;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "rolEnFlota")  // Aquí se ajusta el nombre de la columna
    private String rolEnFlota;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Flota getIdFlota() {
		return idFlota;
	}

	public void setIdFlota(Flota flota) {
		this.idFlota = idFlota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRolEnFlota() {
		return rolEnFlota;
	}

	public void setRolEnFlota(String rolEnFlota) {
		this.rolEnFlota = rolEnFlota;
	}

	public Tripulacion(Long id, Flota id_flota, String nombre, String rolEnFlota) {
		super();
		this.id = id;
		this.idFlota = id_flota;
		this.nombre = nombre;
		this.rolEnFlota = rolEnFlota;
	}

	public Tripulacion() {
		super();
	}

    // Getters y Setters
    
}