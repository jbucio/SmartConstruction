package mx.tiid.smartconstruction.bean;



import java.awt.Event;
import java.io.Serializable; 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mx.tiid.smartconstruction.model.Actividades;
import mx.tiid.smartconstruction.model.Empresas;
import mx.tiid.smartconstruction.model.FactoresIncumplimiento;
import mx.tiid.smartconstruction.model.Project;

@ManagedBean
@ViewScoped
public class ActividadesCatalogoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Actividades> listarActividades;
	private Event event;
	
	@PostConstruct
	public void init(){
		listarActividades = new ArrayList<Actividades>();

		Date fecha1 = new Date();
		Empresas empresas1 = new Empresas("Service Corpotare Line");
		Project proyecto1 = new Project();
		proyecto1.setIdProject(1);
		FactoresIncumplimiento factor1 = new FactoresIncumplimiento("Fallas Técnicas");
		
		Actividades actividad1 = new Actividades();
		actividad1.setIdActividad("CortarPiezas");
		actividad1.setEmpresas(empresas1);
		actividad1.setProject(proyecto1);
		actividad1.setFactoresIncumplimiento(factor1);
		actividad1.setFechaAsignada(fecha1);
		actividad1.setFechaComienzo(fecha1);
		actividad1.setFechaTermino(fecha1);
		actividad1.setFechaActualizada(fecha1);
		

		Date fecha2 = new Date();
		Empresas empresas2 = new Empresas("2");
		Project proyecto2 = new Project();
		proyecto2.setIdProject(2);
		FactoresIncumplimiento factor2 = new FactoresIncumplimiento("Problemas Administrativos");
		
		Actividades actividad2 = new Actividades();
		actividad2.setIdActividad("Ensamblado");
		actividad2.setEmpresas(empresas2);
		actividad2.setProject(proyecto2);
		actividad2.setFactoresIncumplimiento(factor2);
		actividad2.setFechaAsignada(fecha2);
		actividad2.setFechaComienzo(fecha2);
		actividad2.setFechaTermino(fecha2);
		actividad2.setFechaActualizada(fecha2);
		
		listarActividades.add(actividad1);
		listarActividades.add(actividad2);
	}

	public List<Actividades> getListarActividades() {
		return listarActividades;
	}

	

}
