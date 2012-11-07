package view;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.FuncionarioDAO;
import es2.atividade2.model.Funcionario;

public class EditarFuncionarioView extends JFrame{
	private static final long serialVersionUID = 1L;

	String[] colunas = { "Nome", "Morada", "Login", "Senha" };
	String[][] dados;
	private JPanel tabela;

	public EditarFuncionarioView() {
		montaTabela();
	}

	private void preencheDados() {

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.conectar();
		List<Funcionario> funcionarios = new ArrayList<Funcionario>(
				funcionarioDAO.select());
		funcionarioDAO.desconectar();

		for (Funcionario f : funcionarios) {
			dados = new String[][] { { f.getNome(), f.getMorada(),
					f.getLogin(), f.getSenha() } };
		}
	}

	private JPanel montaTabela() {
		preencheDados();
		DefaultTableModel modelo = new DefaultTableModel(dados, colunas);

		JTable jtable = new JTable(modelo);
		
		tabela = new JPanel(new FlowLayout(FlowLayout.CENTER));  
		tabela.add(jtable);  
        add(tabela);
        
        return tabela;
	}
}
