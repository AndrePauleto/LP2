package view;

import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.CartaoDAO;
import es2.atividade2.model.Cartao;

public class EditarCartaoView extends JFrame {

	private static final long serialVersionUID = 1L;

	String[] colunas = { "id", "matricula", "acessando", "regra_id" };
	String[][] dados;

	DefaultTableModel modelo = new DefaultTableModel(dados, colunas);

	JTable jtable = new JTable(modelo);

	public EditarCartaoView() {
		adicionaLinha();
		add(jtable);
	}

	public void adicionaLinha() {

		// Obtem o modelo da JTable
		DefaultTableModel modelo = (DefaultTableModel) jtable.getModel();
		// preencherComboBox();
		CartaoDAO cartaoDao = new CartaoDAO();
		cartaoDao.conectar();
		Collection<Cartao> cartaoCol = cartaoDao.select();

		for (Cartao cartao : cartaoCol) {
			modelo.addRow(new String[] { "'" + cartao.getId() + "'",
					"'" + cartao.getMatricula() + "'",
					"'" + cartao.isAcessando() + "'",
					"'" + cartao.getRegra().getId() + "'" });
		}

		cartaoDao.desconectar();
	}

}
