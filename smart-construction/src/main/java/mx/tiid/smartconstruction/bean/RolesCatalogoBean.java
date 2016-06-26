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
	
	/*
	 * Se crea el objeto para interactuar con la BD
	 * Generar getter y setter
	 * */
	private RolUsuarios rol;
	
	@PostConstruct
	public void init() {
		
		listarRolUsuarios();
		//Inicializar el objeto
		rol = new RolUsuarios();
	}
	
	public void insertRol(){
		
		rolesServiceImpl.insert(rol);
		init();
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

	public RolUsuarios getRol() {
		return rol;
	}

	public void setRol(RolUsuarios rol) {
		this.rol = rol;
	}
	
	

}