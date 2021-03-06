package mx.tiid.smartconstruction.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import mx.tiid.smartconstruction.model.Actividades;
import mx.tiid.smartconstruction.model.Usuarios;

@Component
public interface IActividadeDAO {

	public List<Actividades> actividadesByUsuario(Usuarios usuario);
	
	@Transactional
	public List<Actividades> findActividades();
}
