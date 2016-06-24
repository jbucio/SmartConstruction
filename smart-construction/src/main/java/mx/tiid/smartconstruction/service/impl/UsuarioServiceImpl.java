package mx.tiid.smartconstruction.service.impl;

import java.util.List;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.tiid.smartconstruction.bean.SessionBean;
import mx.tiid.smartconstruction.dao.IUsuarioDAO;
import mx.tiid.smartconstruction.dao.impl.UsuarioDAOImpl;
import mx.tiid.smartconstruction.model.Usuarios;
import mx.tiid.smartconstruction.service.IUsuarioService;
import mx.tiid.smartconstruction.util.Message;
import mx.tiid.smartconstruction.util.NavRedirect;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDAO iUsuarioDAO;
	
	@Override
	public Usuarios findUser(Usuarios usuario) {

		return iUsuarioDAO.findUsuario(usuario);
	}

	@Override
	public List<Usuarios> getListUsuarios() {
		return iUsuarioDAO.findAll();
	}


}
