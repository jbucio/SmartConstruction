package mx.tiid.smartconstruction.service;

import java.util.List;

import org.springframework.stereotype.Component;

import mx.tiid.smartconstruction.model.Usuarios;

@Component
public interface IUsuarioService {

	public Usuarios findUser(Usuarios usuario);

	public List<Usuarios> getListUsuarios();
}
