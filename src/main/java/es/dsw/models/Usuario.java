package es.dsw.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id_usuario")
	    private Long idUsuario;
		@Column(name = "alias")
	    private String alias;
		@Column(name = "contraseña")
	    private String contraseña;
		@Column(name = "email")
	    private String email;
		@Column(name = "id_rol")
	    private Long rolId;
		@Column(name = "id_flota")
	    private Long flota;
	
		public Usuario() {
			
		}
	
		public Long getIdUsuario() {
			return idUsuario;
		}
		public void setIdUsuario(Long idUsuario) {
			this.idUsuario = idUsuario;
		}
		public String getAlias() {
			return alias;
		}
		public void setAlias(String alias) {
			this.alias = alias;
		}
		public String getContraseña() {
			return contraseña;
		}
		public void setContraseña(String contraseña) {
			this.contraseña = contraseña;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Long getRolId() {
			return rolId;
		}
		public void setRolId(Long rolId) {
			this.rolId = rolId;
		}
		public Long getFlota() {
			return flota;
		}
		public void setFlota(Long flota) {
			this.flota = flota;
		}
		public Usuario(Long idUsuario, String alias, String contraseña, String email, Long rolId, Long flota) {
			super();
			this.idUsuario = idUsuario;
			this.alias = alias;
			this.contraseña = contraseña;
			this.email = email;
			this.rolId = rolId;
			this.flota = flota;
		}
		
		
	}