package mx.tiid.smartconstruction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.tiid.smartconstruction.dao.IRolesDAO;
import mx.tiid.smartconstruction.model.RolUsuarios;
import mx.tiid.smartconstruction.service.IRolesService;

@Component
public class RolesServiceImpl implements IRolesService {
	
	@Autowired
	private IRolesDAO rolDAO;

	@Override
	public List<RolUsuarios> getList() {
		// TODO Auto-generated method stub
		return rolDAO.findAll();
	}

}
