package mx.tiid.smartconstruction.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import mx.tiid.smartconstruction.model.RolUsuarios;
import mx.tiid.smartconstruction.service.impl.RolesServiceImpl;;

@ManagedBean
@ViewScoped
public class RolesCatalogoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{rolesServiceImpl}" )
	private RolesServiceImpl rolesServiceImpl;
	
	private List<RolUsuarios> listarRolUsuarios;
	
	@PostConstruct
	public void init() {
		
		listarRolUsuarios();
	}
	
	private void listarRolUsuarios(){
		listarRolUsuarios = rolesServiceImpl.getList();
	}
	
	public List<RolUsuarios> getListRolUsuarios(){
		return listarRolUsuarios;
	}
	
	public void setListRolUsuarios(List<RolUsuarios> listRolUsuarios){
		this.listarRolUsuarios = listRolUsuarios;
	}

	public void setRolesServiceImpl(RolesServiceImpl rolesServiceImpl) {
		this.rolesServiceImpl = rolesServiceImpl;
	}
	
	

}