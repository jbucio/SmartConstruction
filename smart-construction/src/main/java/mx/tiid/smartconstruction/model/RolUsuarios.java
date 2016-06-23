package mx.tiid.smartconstruction.model;
// Generated 27-feb-2016 12:36:04 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * RolUsuarios generated by hbm2java
 */
public class RolUsuarios implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String idRol;
	private String nombre;
	private Set<Usuarios> usuarioses = new HashSet<Usuarios>(0);

	public RolUsuarios() {
	}

	public RolUsuarios(String idRol) {
		this.idRol = idRol;
	}

	public RolUsuarios(String idRol, String nombre, Set<Usuarios> usuarioses) {
		this.idRol = idRol;
		this.nombre = nombre;
		this.usuarioses = usuarioses;
	}

	public String getIdRol() {
		return this.idRol;
	}

	public void setIdRol(String idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Usuarios> getUsuarioses() {
		return this.usuarioses;
	}

	public void setUsuarioses(Set<Usuarios> usuarioses) {
		this.usuarioses = usuarioses;
	}

}
