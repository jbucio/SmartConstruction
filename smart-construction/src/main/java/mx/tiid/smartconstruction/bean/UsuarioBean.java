package mx.tiid.smartconstruction.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import mx.tiid.smartconstruction.dao.impl.UsuarioDAOImpl;
import mx.tiid.smartconstruction.model.Usuarios;
import mx.tiid.smartconstruction.service.IUsuarioService;
import mx.tiid.smartconstruction.service.impl.UsuarioServiceImpl;
import mx.tiid.smartconstruction.util.Message;
import mx.tiid.smartconstruction.util.NavRedirect;

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuarios usuario;

	@ManagedProperty(value = "#{sessionBean}")
	private SessionBean sessionBean;

	@ManagedProperty(value = "#{usuarioServiceImpl}")
	private UsuarioServiceImpl usuarioServiceImpl;

	@PostConstruct
	public void init() {
		this.usuario = new Usuarios();
	}

	/*
	 * Iniciar session dentro del aplicativo
	 */
	public String inciarSession() {

		Usuarios user = usuarioServiceImpl.findUser(usuario);

		if (user == null) {

			Message.getErrorMessage("Usuario y/o Password Incorresto");
			return "";
		}

		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
		sessionBean.setUsuario(user);

		Message.getInfoMessage("Bienvenido: " + user.getNombres());

		return NavRedirect.DASHBOARD_REDIRECT;
	}

	/*
	 * Valida si existe una session con usuario correcto
	 */
	public void verificarSession(String key) {

		Usuarios usuarioSesionUsuario;
		try {

			FacesContext context = FacesContext.getCurrentInstance();
			usuarioSesionUsuario = (Usuarios) context.getExternalContext().getSessionMap().get("usuario");
			if (usuarioSesionUsuario == null) {
				context.getExternalContext().redirect("http://smartconstruction.mx/");
			}

			switch (key) {
			case "planillasemanal":

				// if
				// (!usuarioSesionUsuario.getIdRol().equalsIgnoreCase("ROL0002"))
				// {
				// context.getExternalContext().redirect("http://smartconstruction.mx/");
				// }
				break;

			default:
				break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Cierra la session actual del usuario
	 */
	public String cerrarSession() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("http://smartconstruction.mx/");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "login?faces-redirect=true";
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	public void setUsuarioServiceImpl(UsuarioServiceImpl usuarioServiceImpl) {
		this.usuarioServiceImpl = usuarioServiceImpl;
	}

}
