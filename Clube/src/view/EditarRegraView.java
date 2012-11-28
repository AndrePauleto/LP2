package view;

import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.RegraDAO;
import es2.atividade2.model.Regra;

public class EditarRegraView extends JFrame {

	private static final long serialVersionUID = 1L;

	String[] colunas = { "id", "nomeCartao", "horaInicial", "horaFinal",
			"numeroAcessoDia", "valor", "diasDaSemana_id" };
	String[][] dados;

	DefaultTableModel modelo = new DefaultTableModel(dados, colunas);

	JTable jtable = new JTable(modelo);

	public EditarRegraView() {
		adicionaLinha();
		add(jtable);
	}

	public void adicionaLinha() {

		// Obtem o modelo da JTable
		DefaultTableModel modelo = (DefaultTableModel) jtable.getModel();
		// preencherComboBox();
		RegraDAO regraDao = new RegraDAO();
		regraDao.conectar();
		Collection<Regra> regraCol = regraDao.select();

		for (Regra regra : regraCol) {
			modelo.addRow(new String[] { "'" + regra.getId() + "'",
					"'" + regra.getNomeCartao() + "'",
					"'" + regra.getHoraInicial() + "'",
					"'" + regra.getHoraFinal() + "'",
					"'" + regra.getNumeroAcessoDia() + "'",
					"'" + regra.getValor() + "'",
					"'" + regra.getDiasDaSemana().getId() + "'" });
		}

		regraDao.desconectar();

	}

}
