package mx.tiid.smartconstruction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.tiid.smartconstruction.dao.impl.ActividadDAOImpl;
import mx.tiid.smartconstruction.model.Actividades;
import mx.tiid.smartconstruction.model.Usuarios;
import mx.tiid.smartconstruction.service.IActividadService;

@Service
public class ActividadServiceImpl implements IActividadService {

	@Autowired
	ActividadDAOImpl actividadDAOImpl;

	@Override
	public List<Actividades> actividadesByUsuario(Usuarios usuario) {

		return actividadDAOImpl.actividadesByUsuario(usuario);
	}

}
