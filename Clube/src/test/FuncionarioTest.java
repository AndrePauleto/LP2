package test;

import org.junit.Test;

import dao.FuncionarioDAO;
import es2.atividade2.model.Funcionario;

public class FuncionarioTest {

	@Test(expected = IllegalArgumentException.class)
	public void testFuncionarioDAOInsert() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.conectar();
		Funcionario u = new Funcionario(1, "Teste2", "Teste2", 22, "Teste2",
				"123");
		funcionarioDAO.insert(u);
		funcionarioDAO.desconectar();
		System.out.println("Funcionario cadastrado com Sucesso!");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFuncionarioDAOSelect() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.conectar();
		funcionarioDAO.select();
		funcionarioDAO.desconectar();
		System.out.println("Select Funcionario com Sucesso!");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFuncionarioDAOUpdate() {

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.conectar();
		funcionarioDAO.select();

		Funcionario u = funcionarioDAO.select(5);
		u.setNome("Manolo");
		u.setMorada("Aquela");
		funcionarioDAO.update(u);

		funcionarioDAO.desconectar();
		System.out.println("Update Funcionario com Sucesso!");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFuncionarioDAODelete() {

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.conectar();
		funcionarioDAO.select();

		Funcionario u = funcionarioDAO.select(7);
		funcionarioDAO.delete(u);
		System.out.println("Delete Funcionario com Sucesso!");
	}

}
