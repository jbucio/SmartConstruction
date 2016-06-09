package mx.tiid.smartconstruction.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import mx.tiid.smartconstruction.model.Usuarios;

@ManagedBean
@ViewScoped
public class UsuariosGridBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Usuarios> listarUsuarios;

	@PostConstruct
	public void init() {
		listarUsuarios = new ArrayList<Usuarios>();
		
		Usuarios usuarios = new Usuarios();
		usuarios.setIdUsuario("1");
		usuarios.setRolUsuarios(null);
		usuarios.setNombres("Juan");
		usuarios.setApaterno("López");
		usuarios.setAmaterno("Díaz");
		usuarios.setPassword("juan");
		usuarios.setUsuario("juan");
		usuarios.setActivo(true);
		
		listarUsuarios.add(usuarios);
	}

	public List<Usuarios> getListarUsuarios() {
		return listarUsuarios;
	}

}