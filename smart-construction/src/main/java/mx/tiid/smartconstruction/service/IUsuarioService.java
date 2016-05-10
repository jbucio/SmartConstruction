package mx.tiid.smartconstruction.service;

import org.springframework.stereotype.Component;

import mx.tiid.smartconstruction.model.Usuarios;

@Component
public interface IUsuarioService {

	
	public Usuarios findUser(Usuarios usuario);
}
