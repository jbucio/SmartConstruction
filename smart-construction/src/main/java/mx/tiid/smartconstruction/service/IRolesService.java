package mx.tiid.smartconstruction.service;

import java.util.List;

import org.springframework.stereotype.Component;

import mx.tiid.smartconstruction.model.RolUsuarios;

@Component
public interface IRolesService {
	public List<RolUsuarios> getList();

}
