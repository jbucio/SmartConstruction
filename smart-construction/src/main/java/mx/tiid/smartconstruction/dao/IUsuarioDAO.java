package mx.tiid.smartconstruction.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import mx.tiid.smartconstruction.model.Usuarios;

@Component
public interface IUsuarioDAO {

	public Usuarios findUsuario(Usuarios usuario);
	
	@Transactional
	public List<Usuarios> findAll();
}
