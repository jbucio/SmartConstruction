package mx.tiid.smartconstruction.service;

import java.util.List;

import org.springframework.stereotype.Component;

import mx.tiid.smartconstruction.model.Actividades;
import mx.tiid.smartconstruction.model.Usuarios;

@Component
public interface IActividadService {

	public List<Actividades> actividadesByUsuario(Usuarios usuario);
}
