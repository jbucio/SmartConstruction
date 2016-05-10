package mx.tiid.smartconstruction.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import mx.tiid.smartconstruction.model.Usuarios;

@ManagedBean
@SessionScoped
public class SessionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuarios usuario = new Usuarios();

	public boolean isCalidad() {
		boolean result = false;

		// if (usuario.getIdRol().equalsIgnoreCase("ROL0002")) {
		// result = true;
		// }

		return result;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

}
