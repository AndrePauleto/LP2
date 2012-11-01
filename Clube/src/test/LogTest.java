package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.LogDAO;
import dao.SocioDAO;

import es2.atividade2.model.Log;
import es2.atividade2.model.Socio;

public class LogTest {

	//FIXME Arrumar para pegar hora no formato brasileiro, sem AM/PM
	/*@Test(expected=IllegalArgumentException.class)
	public void testLogDAOInsert() {		
		LogDAO logDAO = new LogDAO();
		SocioDAO socioDAO = new SocioDAO();
		socioDAO.conectar();
		logDAO.conectar();
		
		Socio s = socioDAO.select(2);
		
		Log u = new Log(s);
		logDAO.insert(u);

		logDAO.desconectar();
		socioDAO.desconectar();		
		System.out.println("Log cadastrado com Sucesso!");
	}*/
	
	@Test(expected=IllegalArgumentException.class)
	public void testLogDAOSelect() {
		LogDAO logDAO = new LogDAO();
		logDAO.conectar();
		System.out.println(logDAO.select());
		logDAO.desconectar();		
		System.out.println("Select Log com Sucesso!");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSocioDAOSelectId() {
		LogDAO logDAO = new LogDAO();
		logDAO.conectar();		
		System.out.println(logDAO.select(3));
		logDAO.desconectar();		
		System.out.println("SelectID Log com Sucesso!");
	}

}
