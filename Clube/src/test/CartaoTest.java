package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.CartaoDAO;
import dao.RegraDAO;

import es2.atividade2.model.Cartao;
import es2.atividade2.model.Regra;

public class CartaoTest {

	/*@Test(expected=IllegalArgumentException.class)
	public void testCartaoDAOInsert() {
		RegraDAO regraDAO = new RegraDAO();
		CartaoDAO cartaoDAO = new CartaoDAO();
		cartaoDAO.conectar();
		regraDAO.conectar();
		
		Regra r = regraDAO.select(1);

		Cartao u = new Cartao(1 ,"33333/2012", r, false);
		cartaoDAO.insert(u);
		
		System.out.println(u);
		regraDAO.desconectar();
		cartaoDAO.desconectar();		
		System.out.println("Cartao cadastrada com Sucesso!");
	}*/
	
	/*@Test(expected=IllegalArgumentException.class)
	public void testCartaoDAOSelect() {
		CartaoDAO cartaoDAO = new CartaoDAO();
		cartaoDAO.conectar();		
		System.out.println(cartaoDAO.select());
		cartaoDAO.desconectar();		
		System.out.println("Select cartao com Sucesso!");
	}*/
	
	/*@Test(expected=IllegalArgumentException.class)
	public void testCartaoDAOSelectId() {
			CartaoDAO cartaoDAO = new CartaoDAO();
			cartaoDAO.conectar();		
			System.out.println(cartaoDAO.select(2));
			cartaoDAO.desconectar();		
			System.out.println("SelectID cartao com Sucesso!");
	}*/
	
	/*@Test(expected=IllegalArgumentException.class)
	public void testCartaoDAOUpdate() {		
		
		CartaoDAO cartaoDAO = new CartaoDAO();
		cartaoDAO.conectar();		
		cartaoDAO.select();
		
		Cartao u = cartaoDAO.select(2);
		u.setMatricula("teste/2012");
				
		cartaoDAO.update(u);		
		
		cartaoDAO.desconectar();		
		System.out.println("Update cartao com Sucesso!");
	}*/
	
	/*@Test(expected=IllegalArgumentException.class)
	public void testCartaoDAODelete() {		
		
		CartaoDAO cartaoDAO = new CartaoDAO();
		cartaoDAO.conectar();		
		cartaoDAO.select();
		
		Cartao u = cartaoDAO.select(3);
		cartaoDAO.delete(u);
		cartaoDAO.desconectar();
		System.out.println("Delete cartao com Sucesso!");
	}*/

}
