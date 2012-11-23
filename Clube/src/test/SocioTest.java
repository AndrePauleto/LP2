package test;

import org.junit.Test;

import dao.CartaoDAO;
import dao.SocioDAO;
import es2.atividade2.model.Cartao;
import es2.atividade2.model.Socio;

public class SocioTest {

	@Test
	public void testSocioDAOInsert() {
		SocioDAO socioDAO = new SocioDAO();
		CartaoDAO cartaoDAO = new CartaoDAO();
		cartaoDAO.conectar();
		socioDAO.conectar();

		Cartao c = cartaoDAO.select(2);

		Socio u = new Socio(0, "TESTE", "Teste", 32, c);
		socioDAO.insert(u);

		System.out.println(u);
		socioDAO.desconectar();
		cartaoDAO.desconectar();
		System.out.println("Socio cadastrado com Sucesso!");
	}

	@Test
	public void testSocioDAOSelect() {
		SocioDAO socioDAO = new SocioDAO();
		socioDAO.conectar();
		System.out.println(socioDAO.select());
		socioDAO.desconectar();
		System.out.println("Select Sócio com Sucesso!");
	}

	@Test
	public void testSocioDAOSelectId() {
		SocioDAO socioDAO = new SocioDAO();
		socioDAO.conectar();
		System.out.println(socioDAO.select(1));
		socioDAO.desconectar();
		System.out.println("SelectID Sócio com Sucesso!");
	}

	@Test
	public void testSocioDAOUpdate() {

		SocioDAO socioDAO = new SocioDAO();
		socioDAO.conectar();
		socioDAO.select();

		Socio u = socioDAO.select(3);
		u.setNome("Manolo");
		u.setIdade(15);

		socioDAO.update(u);

		socioDAO.desconectar();
		System.out.println("Update Sócio com Sucesso!");
	}

	@Test
	public void testSocioDAODelete() {

		SocioDAO socioDAO = new SocioDAO();
		socioDAO.conectar();
		socioDAO.select();

		Socio u = socioDAO.select(3);
		socioDAO.delete(u);
		socioDAO.desconectar();
		System.out.println("Delete Sócio com Sucesso!");
	}

}
