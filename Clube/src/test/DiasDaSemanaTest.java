package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.DiasDaSemanaDAO;
import dao.FuncionarioDAO;
import es2.atividade2.model.DiasDaSemana;
import es2.atividade2.model.Funcionario;

public class DiasDaSemanaTest {

	@Test
	public void testDiasDaSemanaDAOInsert() {
		DiasDaSemanaDAO diasDaSemanaDAO = new DiasDaSemanaDAO();
		diasDaSemanaDAO.conectar();
		DiasDaSemana u = new DiasDaSemana(1, false, false, false, false, false,
				false, false);
		diasDaSemanaDAO.insert(u);
		diasDaSemanaDAO.desconectar();		
		System.out.println("DiasDaSemana cadastrado com Sucesso!");
	}
	
	/*@Test(expected=IllegalArgumentException.class)
	public void testDiasDaSemanaDAOSelect() {
		DiasDaSemanaDAO diasDaSemanaDAO = new DiasDaSemanaDAO();
		diasDaSemanaDAO.conectar();		
		diasDaSemanaDAO.select();
		diasDaSemanaDAO.desconectar();		
		System.out.println("Select DiasDaSemanaDAO com Sucesso!");
	}*/
	
	/*@Test(expected=IllegalArgumentException.class)
	public void testDiasDaSemanaDAOUpdate() {		
		
		DiasDaSemanaDAO diasDaSemanaDAO = new DiasDaSemanaDAO();
		diasDaSemanaDAO.conectar();		
		diasDaSemanaDAO.select();
		
		DiasDaSemana u = diasDaSemanaDAO.select(5);
		u.setTuesday(true);
				
		diasDaSemanaDAO.update(u);		
		
		diasDaSemanaDAO.desconectar();		
		System.out.println("Update DiasDaSemana com Sucesso!");
	}*/
	
	/*@Test(expected=IllegalArgumentException.class)
	public void testDiasDaSemanaDAODelete() {		
		
		DiasDaSemanaDAO diasDaSemanaDAO = new DiasDaSemanaDAO();
		diasDaSemanaDAO.conectar();		
		diasDaSemanaDAO.select();
		
		DiasDaSemana u = diasDaSemanaDAO.select(6);
		diasDaSemanaDAO.delete(u);
		System.out.println("Delete DiasDaSemana com Sucesso!");
	}*/

}
