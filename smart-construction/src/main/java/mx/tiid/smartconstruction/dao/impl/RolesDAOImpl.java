package mx.tiid.smartconstruction.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.tiid.smartconstruction.dao.IRolesDAO;
import mx.tiid.smartconstruction.model.RolUsuarios;

@Repository
public class RolesDAOImpl implements IRolesDAO {
	
	@Autowired
	SessionFactory sessionFactory;

//	@Transactional(readOnly = true)
	@Override
	public List<RolUsuarios> findAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from RolUsuarios").list();
	}

}
