package mx.tiid.smartconstruction.bean;

import java.io.Serializable; 
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import mx.tiid.smartconstruction.model.Actividades;
import mx.tiid.smartconstruction.service.impl.ActividadServiceImpl;

@ManagedBean
@ViewScoped
public class ActividadesCatalogoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{actividadServiceImpl}")
	private ActividadServiceImpl actividadServiceImpl;
	
	private List<Actividades> listarActividades;
	
	@PostConstruct
	public void init(){
		
		listarActividades();
	}
	
	private void listarActividades(){
		listarActividades = actividadServiceImpl.getListActividades();
	}

	public List<Actividades> getListarActividades() {
		return listarActividades;
	}
	
	public void setListarActividades(List<Actividades> listActividades) {
		this.listarActividades = listActividades;
	}

	public void setActividadServiceImpl(ActividadServiceImpl actividadServiceImpl) {
		this.actividadServiceImpl = actividadServiceImpl;
	}

	

}
