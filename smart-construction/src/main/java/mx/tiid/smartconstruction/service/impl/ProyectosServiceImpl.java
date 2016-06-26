package mx.tiid.smartconstruction.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.tiid.smartconstruction.dao.IProyectosDAO;
import mx.tiid.smartconstruction.model.Proyectos;
import mx.tiid.smartconstruction.service.IProyectosService;

@Service
public class ProyectosServiceImpl implements IProyectosService{
	
	@Autowired
	private IProyectosDAO proyectosDAO;
	
	@Override
	public List<Proyectos> getListProyectos(){
		// TODO Auto-generated method stub
		return proyectosDAO.findProyectos();
	}

}
