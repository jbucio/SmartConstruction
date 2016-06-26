package mx.tiid.smartconstruction.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.tiid.smartconstruction.dao.IActividadeDAO;
import mx.tiid.smartconstruction.model.Actividades;
import mx.tiid.smartconstruction.model.Proyectos;
import mx.tiid.smartconstruction.model.Usuarios;

@Repository
@Scope(value = "prototype")
public class ActividadDAOImpl implements IActividadeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Actividades> actividadesByUsuario(Usuarios usuario) {

		List<Actividades> listActividades = null;

		String sql = "select distinct a from Project p inner join p.actividadeses a where a.usuarios.idUsuario = :usuario and p.actividad = :actividad";

		try {
			Query query = sessionFactory.openSession().createQuery(sql);
			query.setParameter("usuario", "US001");
			query.setParameter("actividad", true);

			listActividades = query.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listActividades;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//Busqueda paginada
	@Transactional(readOnly=true)
	@Override
	public List<Actividades> findActividades(){
		
		List<Actividades> listActividades = null;

		
		return listActividades;
	}
}
