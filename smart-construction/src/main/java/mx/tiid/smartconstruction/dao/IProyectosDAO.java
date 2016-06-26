package mx.tiid.smartconstruction.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import mx.tiid.smartconstruction.model.Proyectos;

@Component
public interface IProyectosDAO {
	
	@Transactional
	public List<Proyectos> findProyectos();

}
