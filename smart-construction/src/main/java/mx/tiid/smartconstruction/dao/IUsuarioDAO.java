package mx.tiid.smartconstruction.dao;

import org.springframework.stereotype.Component;

import mx.tiid.smartconstruction.model.Usuarios;

@Component
public interface IUsuarioDAO {

	public Usuarios findUsuario(Usuarios usuario);

}
