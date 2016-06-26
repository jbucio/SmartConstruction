package mx.tiid.smartconstruction.service;

import java.util.List;

import org.springframework.stereotype.Component;

import mx.tiid.smartconstruction.model.Proyectos;

@Component
public interface IProyectosService {
	
	public List<Proyectos> getListProyectos();
}
