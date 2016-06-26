package mx.tiid.smartconstruction.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import mx.tiid.smartconstruction.model.Proyectos;
import mx.tiid.smartconstruction.service.impl.ProyectosServiceImpl;

@ManagedBean
@ViewScoped
public class ProyectosCatalogoBean implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{proyectosServiceImpl}")
	private ProyectosServiceImpl proyectosServiceImpl;
	
	private List<Proyectos> listarProyectos;
	
	@PostConstruct
	public void init(){
			
		listarProyectos();
	}
	
	private void listarProyectos(){
		listarProyectos = proyectosServiceImpl.getListProyectos();
	}

	public List<Proyectos> getListarProyectos() {
		return listarProyectos;
	}

	public void setListarProyectos(List<Proyectos> listProyectos) {
		this.listarProyectos = listProyectos;
	}

	public void setProyectosServiceImpl(ProyectosServiceImpl proyectosServiceImpl) {
		this.proyectosServiceImpl = proyectosServiceImpl;
	}

	

}
