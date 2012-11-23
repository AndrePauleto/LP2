package view;

import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.FuncionarioDAO;
import es2.atividade2.model.Funcionario;

public class EditarFuncionarioView extends JFrame {
	private static final long serialVersionUID = 1L;

	String[] colunas = { "id", "Nome", "Idade", "Morada", "Login", "Senha" };
	String[][] dados;

	DefaultTableModel modelo = new DefaultTableModel(dados, colunas);

	JTable jtable = new JTable(modelo);

	public EditarFuncionarioView() {
		adicionaLinha();
		add(jtable);
	}

	public void adicionaLinha() {

		// Obtem o modelo da JTable
		DefaultTableModel modelo = (DefaultTableModel) jtable.getModel();
		// preencherComboBox();
		FuncionarioDAO funcionarioDao = new FuncionarioDAO();
		funcionarioDao.conectar();
		Collection<Funcionario> funcionarioCol = funcionarioDao.select();

		for (Funcionario f : funcionarioCol) {
			modelo.addRow(new String[] { "'" + f.getId() + "'",
					"'" + f.getIdade() + "'", "'" + f.getNome() + "'",
					"'" + f.getMorada() + "'", "'" + f.getLogin() + "'",
					"'" + f.getSenha() + "'" });
		}

		funcionarioDao.desconectar();

	}
}
