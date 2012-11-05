package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.AbstractAction;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.RegraDAO;
import es2.atividade2.model.Cartao;
import es2.atividade2.model.Regra;

public class CadastrarCartaoView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel lblMatricula;	
	private JTextField txtMatricula;
	private JComboBox cmbxRegra;
	
	public CadastrarCartaoView() {
		montaTela();
	}
	
	private void montaTela() {
		setTitle("SysClub - Cadastra Cartão");
		
		lblMatricula = new JLabel();
		lblMatricula.setText("Matrícula:");
		txtMatricula = new JTextField(15);
		ArrayList<Regra> r = new ArrayList<Regra>();
		
		JPanel panel = new JPanel(new GridLayout(3, 1));
		
		RegraDAO regraDAO = new RegraDAO();
		regraDAO.conectar();
		Collection<Regra> c = regraDAO.select();
		
		for (Regra regra : c) {
			r = (ArrayList<Regra>) c;
		}	
		
		// Ver como converter collections em objects
		//cmbxRegra = new JComboBox(null);
		System.out.println(r);
		regraDAO.desconectar();

		


		regraDAO.desconectar();
		
		//panel.add(cmbxRegra);
		
	}
}
