package mx.tiid.smartconstruction.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.tiid.smartconstruction.dao.IProyectosDAO;
import mx.tiid.smartconstruction.model.Proyectos;

@Repository
public class ProyectosDAOImpl implements IProyectosDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional(readOnly=true)
	@Override
	public List<Proyectos> findProyectos(){
		return sessionFactory.getCurrentSession().createQuery("from Proyectos").list();
	}
}
