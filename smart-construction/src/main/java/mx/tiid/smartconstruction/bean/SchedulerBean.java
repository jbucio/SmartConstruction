package mx.tiid.smartconstruction.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import mx.tiid.smartconstruction.model.Actividades;
import mx.tiid.smartconstruction.model.Usuarios;
import mx.tiid.smartconstruction.service.impl.ActividadServiceImpl;

@ManagedBean
@ViewScoped
public class SchedulerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{actividadServiceImpl}")
	private ActividadServiceImpl actividadServiceImpl;

	private Actividades actividad;

	private DefaultScheduleEvent scheduleEvent;
	private ScheduleModel eventModel;
	private ScheduleEvent event;

	@PostConstruct
	public void init() {
		cargaActividades();
	}

	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
		this.actividad = (Actividades) event.getData();
	}

	public void cargaActividades() {
		Usuarios usuario = new Usuarios();
		List<Actividades> listActividades = actividadServiceImpl.actividadesByUsuario(usuario);
		eventModel = new DefaultScheduleModel();
		for (Actividades actividad : listActividades) {
			scheduleEvent = new DefaultScheduleEvent(actividad.getProject().getNombre(), actividad.getProject().getFechaComienzo(),
					actividad.getProject().getFechaTermino(), actividad);

			eventModel.addEvent(scheduleEvent);

		}
	}

	public DefaultScheduleEvent getScheduleEvent() {
		return scheduleEvent;
	}

	public void setScheduleEvent(DefaultScheduleEvent scheduleEvent) {
		this.scheduleEvent = scheduleEvent;
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	public void setActividadServiceImpl(ActividadServiceImpl actividadServiceImpl) {
		this.actividadServiceImpl = actividadServiceImpl;
	}

	public Actividades getActividad() {
		return actividad;
	}

	public void setActividad(Actividades actividad) {
		this.actividad = actividad;
	}

}
