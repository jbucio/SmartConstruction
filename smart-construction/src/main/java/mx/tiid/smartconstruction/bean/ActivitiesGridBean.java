package mx.tiid.smartconstruction.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.format.annotation.DateTimeFormat;

import mx.tiid.smartconstruction.model.Actividades;

@ManagedBean
@ViewScoped
public class ActivitiesGridBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Actividades> listarActividades;
	
	
	@PostConstruct
	public void init() {
		
		listarActividades = new ArrayList<Actividades>();

		Date fecha1 = new Date(12/12/2015);
		Actividades actividad1 = new Actividades();
		actividad1.setIdActividad("CortarPiezas");
		actividad1.setFechaAsignada(fecha1);

		Date fecha2 = new Date(1992/10/07);
		Actividades actividad2 = new Actividades();
		actividad2.setIdActividad("Ensamblado");
		actividad2.setFechaActualizada(fecha2);
		
		
		
		listarActividades.add(actividad1);
		listarActividades.add(actividad2);

	}

	public List<Actividades> getListarActividades() {
		return listarActividades;
	}

	
	

}
