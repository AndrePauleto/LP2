package view;

import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.SocioDAO;
import es2.atividade2.model.Socio;

public class EditarSocioView extends JFrame {

	private static final long serialVersionUID = 1L;

	String[] colunas = { "id", "nome", "morada", "idade", "cartao_id" };
	String[][] dados;

	DefaultTableModel modelo = new DefaultTableModel(dados, colunas);

	JTable jtable = new JTable(modelo);

	public EditarSocioView() {
		adicionaLinha();
		add(jtable);
	}

	public void adicionaLinha() {

		// Obtem o modelo da JTable
		DefaultTableModel modelo = (DefaultTableModel) jtable.getModel();
		// preencherComboBox();
		SocioDAO socioDao = new SocioDAO();
		socioDao.conectar();
		Collection<Socio> socioCol = socioDao.select();

		for (Socio socio : socioCol) {
			modelo.addRow(new String[] { "'" + socio.getId() + "'",
					"'" + socio.getNome() + "'", "'" + socio.getMorada() + "'",
					"'" + socio.getIdade() + "'",
					"'" + socio.getCartao().getId() + "'" });
		}

		socioDao.desconectar();
	}

}
