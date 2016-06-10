package mx.tiid.smartconstruction.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mx.tiid.smartconstruction.model.Proyectos;

@ManagedBean
@ViewScoped
public class ProyectosCatalogoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<Proyectos> listarProyectos;
	
	@PostConstruct
	public void init(){
		listarProyectos = new ArrayList<Proyectos>();
		
		Proyectos proyecto1 = new Proyectos();
		proyecto1.setIdProyecto("1");
		proyecto1.setNombreProyecto("Smart-Construction");
		proyecto1.setActivo(true);
		proyecto1.setFinalizado(false);
		
		Proyectos proyecto2 = new Proyectos();
		proyecto2.setIdProyecto("2");
		proyecto2.setNombreProyecto("Pepe y toño");
		proyecto2.setActivo(false);
		proyecto2.setFinalizado(true);
		
		listarProyectos.add(proyecto1);
		listarProyectos.add(proyecto2);
	}

	public List<Proyectos> getListarProyectos() {
		return listarProyectos;
	}


}
