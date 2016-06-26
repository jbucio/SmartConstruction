package mx.tiid.smartconstruction.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.tiid.smartconstruction.dao.IRolesDAO;
import mx.tiid.smartconstruction.model.RolUsuarios;
import mx.tiid.smartconstruction.service.IRolesService;

@Component
public class RolesServiceImpl implements IRolesService,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private IRolesDAO rolDAO;

	@Override
	public List<RolUsuarios> getList() {
		// TODO Auto-generated method stub
		return rolDAO.findAll();
	}

	@Override
	public void insert(RolUsuarios rol) {
		// TODO Auto-generated method stub
		rolDAO.save(rol);
	}

}
