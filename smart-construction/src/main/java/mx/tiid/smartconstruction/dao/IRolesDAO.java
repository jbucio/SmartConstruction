package mx.tiid.smartconstruction.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import mx.tiid.smartconstruction.model.RolUsuarios;

@Component
public interface IRolesDAO {
	
	@Transactional
	public List<RolUsuarios> findAll();

	@Transactional
	public void save(RolUsuarios rol);

}
