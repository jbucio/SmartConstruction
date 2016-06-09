package mx.tiid.smartconstruction.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mx.tiid.smartconstruction.model.RolUsuarios;

@ManagedBean
@ViewScoped

public class RolesCaralogoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<RolUsuarios> listarRolUsuarios;
	
	@PostConstruct
	public void init() {
		listarRolUsuarios = new ArrayList<RolUsuarios>();
		
		RolUsuarios usuario1 = new RolUsuarios();
		usuario1.setIdRol("1");
		usuario1.setNombre("jesus");
		
		listarRolUsuarios.add(usuario1);
	}

public List<RolUsuarios> getListarRolUsuarios(){
	return listarRolUsuarios;
}

}
