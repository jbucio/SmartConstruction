package mx.tiid.smartconstruction.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.tiid.smartconstruction.dao.IUsuarioDAO;
import mx.tiid.smartconstruction.model.Usuarios;

@Repository
@Scope(value = "prototype")
public class UsuarioDAOImpl implements IUsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Usuarios findUsuario(Usuarios usuario) {

		Query query = sessionFactory.openSession().createQuery(
				"from Usuarios u where u.usuario = :usuario and u.password = :password and activo = :activo ");
		query.setParameter("usuario", usuario.getUsuario());
		query.setParameter("password", usuario.getPassword());
		query.setParameter("activo", true);

		Usuarios user = (Usuarios) query.uniqueResult();
		return user;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Usuarios> findAll() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Usuarios").list();
	}
}
