package mx.tiid.smartconstruction.model;
// Generated 27-feb-2016 12:36:04 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Project generated by hbm2java
 */
public class Project implements java.io.Serializable {

	private Integer idProject;
	private Proyectos proyectos;
	private String nombre;
	private Date fechaComienzo;
	private Date fechaTermino;
	private String indice;
	private boolean hito;
	private boolean actividad;
	private Set<Actividades> actividadeses = new HashSet<Actividades>(0);

	public Project() {
	}

	public Project(Proyectos proyectos, String nombre, Date fechaComienzo, Date fechaTermino, String indice,
			boolean hito, boolean actividad) {
		this.proyectos = proyectos;
		this.nombre = nombre;
		this.fechaComienzo = fechaComienzo;
		this.fechaTermino = fechaTermino;
		this.indice = indice;
		this.hito = hito;
		this.actividad = actividad;
	}

	public Project(Proyectos proyectos, String nombre, Date fechaComienzo, Date fechaTermino, String indice,
			boolean hito, boolean actividad, Set<Actividades> actividadeses) {
		this.proyectos = proyectos;
		this.nombre = nombre;
		this.fechaComienzo = fechaComienzo;
		this.fechaTermino = fechaTermino;
		this.indice = indice;
		this.hito = hito;
		this.actividad = actividad;
		this.actividadeses = actividadeses;
	}

	public Integer getIdProject() {
		return this.idProject;
	}

	public void setIdProject(Integer idProject) {
		this.idProject = idProject;
	}

	public Proyectos getProyectos() {
		return this.proyectos;
	}

	public void setProyectos(Proyectos proyectos) {
		this.proyectos = proyectos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaComienzo() {
		return this.fechaComienzo;
	}

	public void setFechaComienzo(Date fechaComienzo) {
		this.fechaComienzo = fechaComienzo;
	}

	public Date getFechaTermino() {
		return this.fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public String getIndice() {
		return this.indice;
	}

	public void setIndice(String indice) {
		this.indice = indice;
	}

	public boolean isHito() {
		return this.hito;
	}

	public void setHito(boolean hito) {
		this.hito = hito;
	}

	public boolean isActividad() {
		return this.actividad;
	}

	public void setActividad(boolean actividad) {
		this.actividad = actividad;
	}

	public Set<Actividades> getActividadeses() {
		return this.actividadeses;
	}

	public void setActividadeses(Set<Actividades> actividadeses) {
		this.actividadeses = actividadeses;
	}

	@Override
	public String toString() {
		return "Project [idProject=" + idProject + ", proyectos=" + proyectos + ", nombre=" + nombre
				+ ", fechaComienzo=" + fechaComienzo + ", fechaTermino=" + fechaTermino + ", indice=" + indice
				+ ", hito=" + hito + ", actividad=" + actividad + ", actividadeses=" + actividadeses + "]";
	}

}
