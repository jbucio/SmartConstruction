package mx.tiid.smartconstruction.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

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
}
