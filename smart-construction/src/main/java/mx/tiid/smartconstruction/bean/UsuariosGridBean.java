package mx.tiid.smartconstruction.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import mx.tiid.smartconstruction.model.Usuarios;
import mx.tiid.smartconstruction.service.impl.UsuarioServiceImpl;

@ManagedBean
@ViewScoped
public class UsuariosGridBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{usuarioServiceImpl}")
	private UsuarioServiceImpl usuarioServiceImpl;

	private List<Usuarios> listarUsuarios;

	@PostConstruct
	public void init() {
		listarUsuarios();
	}
	
	public void listarUsuarios(){
		listarUsuarios = usuarioServiceImpl.getListUsuarios();
	}

	public List<Usuarios> getListarUsuarios() {
		return listarUsuarios;
	}
	
	public void setListarUsuarios(List<Usuarios> listarUsuarios) {
		this.listarUsuarios = listarUsuarios;
	}

	public void setUsuarioServiceImpl(UsuarioServiceImpl usuarioServiceImpl) {
		this.usuarioServiceImpl = usuarioServiceImpl;
	}
	
	
}