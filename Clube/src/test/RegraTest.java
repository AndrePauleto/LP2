package test;

import org.junit.Test;

import dao.DiasDaSemanaDAO;
import dao.RegraDAO;
import es2.atividade2.model.DiasDaSemana;
import es2.atividade2.model.Regra;

public class RegraTest {

	@Test
	public void testRegraDAOInsert() {
		DiasDaSemanaDAO diasDaSemanaDAO = new DiasDaSemanaDAO();
		RegraDAO regraDAO = new RegraDAO();
		regraDAO.conectar();
		diasDaSemanaDAO.conectar();

		DiasDaSemana d = diasDaSemanaDAO.select(3);

		Regra u = new Regra(1, "Teste4", "10:00", "22:00", d, "Ilimitado",
				50.50);
		regraDAO.insert(u);

		System.out.println(regraDAO.getUltimoId());
		diasDaSemanaDAO.desconectar();
		regraDAO.desconectar();
		System.out.println("Regra cadastrada com Sucesso!");
	}

	@Test
	public void testRegraDAOSelect() {
		RegraDAO regraDAO = new RegraDAO();
		regraDAO.conectar();
		System.out.println(regraDAO.select());
		regraDAO.desconectar();
		System.out.println("Select Regra com Sucesso!");
	}

	@Test
	public void testRegraDAOSelectId() {
		RegraDAO regraDAO = new RegraDAO();
		regraDAO.conectar();
		System.out.println(regraDAO.select(2));
		regraDAO.desconectar();
		System.out.println("SelectID Regra com Sucesso!");
	}

	@Test
	public void testRegraDAOUpdate() {

		RegraDAO regraDAO = new RegraDAO();
		regraDAO.conectar();
		regraDAO.select();

		Regra u = regraDAO.select(2);
		u.setNomeCartao("Premium");
		u.setHoraInicial("12:00");

		regraDAO.update(u);

		regraDAO.desconectar();
		System.out.println("Update Regra com Sucesso!");
	}

	@Test
	public void testRegraDAODelete() {

		RegraDAO regraDAO = new RegraDAO();
		regraDAO.conectar();
		regraDAO.select();

		Regra u = regraDAO.select(3);
		regraDAO.delete(u);
		System.out.println("Delete Regra com Sucesso!");
		regraDAO.desconectar();
	}
}
