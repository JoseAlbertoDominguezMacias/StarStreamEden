package es.dsw.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mision")
public class Mision {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mision")
    private Long idMision;
	
	@Column(name = "titulo")
    private String titulo;
	
	@Column(name = "descripcion")
    private String descripcion;


    
    public Long getIdMision() {
		return idMision;
	}


	public void setIdMision(Long idMision) {
		this.idMision = idMision;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Mision(Long idMision, String titulo, String descripcion) {
		super();
		this.idMision = idMision;
		this.titulo = titulo;
		this.descripcion = descripcion;
	}


	public Mision() {
		super();
	}
}
