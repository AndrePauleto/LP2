package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.AbstractAction;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import dao.CartaoDAO;
import dao.DiasDaSemanaDAO;
import dao.RegraDAO;
import es2.atividade2.model.Cartao;
import es2.atividade2.model.DiasDaSemana;
import es2.atividade2.model.Regra;

public class CadastrarCartaoView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel lblMatricula;
	private JTextField txtMatricula;
	private JLabel lblRegra;
	private JComboBox cmbxRegra = new JComboBox();

	private JPanel panel;
	private JPanel panelBotoes;
	private JButton cadastrar;
	private JButton cancelar;
	
	String matricula;
	int id_regra;

	public CadastrarCartaoView() {
		montaTela();
		botaoCadastar();
	}

	private void montaTela() {
		setTitle("SysClub - Cadastra Cartão");

		// ---------- Instancia Label/TextField------------
		lblMatricula = new JLabel();
		lblMatricula.setText("Matrícula:");
		txtMatricula = new JTextField(15);

		lblRegra = new JLabel();
		lblRegra.setText("Regra:");

		// ---------- Instancia Combo e preenche com valores do Banco
		// ------------
		RegraDAO regraDAO = new RegraDAO();
		regraDAO.conectar();
		Collection<Regra> c = regraDAO.select();

		cmbxRegra = new JComboBox();

		for (Regra regra : c) {
			Regra r = regra;
			cmbxRegra.addItem(r.getId() + " - " + r.getNomeCartao());
		}

		regraDAO.desconectar();

		// ---------- Instancia Botões ------------
		cadastrar = new JButton("Cadastrar");
		cancelar = new JButton("Cancelar");
		this.getRootPane().setDefaultButton(cadastrar);

		// ------------ Preenche dados nos paineis --------------
		panel = new JPanel(new GridLayout(4, 3));
		panel.setBorder(new TitledBorder("Cartão"));

		panelBotoes = new JPanel(new GridLayout(1, 2));
		panelBotoes.setBorder(new TitledBorder("Opções"));

		panel.add(lblMatricula);
		panel.add(txtMatricula);
		panel.add(lblRegra);
		panel.add(cmbxRegra);
		panelBotoes.add(cadastrar);
		panelBotoes.add(cancelar);
		add(panel, "North");
		add(panelBotoes, "South");

	}

	private void botaoCadastar() {
		cadastrar.addActionListener(new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					getCampos();
					
					RegraDAO regraDAO = new RegraDAO();
					CartaoDAO cartaoDAO = new CartaoDAO();
					cartaoDAO.conectar();
					regraDAO.conectar();
					
					Regra r = regraDAO.select(id_regra);

					Cartao u = new Cartao(1 ,matricula, r, false);
					cartaoDAO.insert(u);					
					
					regraDAO.desconectar();
					cartaoDAO.desconectar();					
										
					limpaCampos();
					JOptionPane.showMessageDialog(null,
							"Cartão cadastrado com Sucesso", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,
							"Não foi possível cadsatrar o Cartão", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

	}
	
	private void getCampos() {
		matricula = txtMatricula.getText();
		
		//recebe valor da combo box
		String cmbxSelecionado = (String) cmbxRegra.getSelectedItem();
		
		//Utiliza o "-" como separador para obeter a String ID
		String[] strId = cmbxSelecionado.split(" -");
		
		//Converte este String ID para inteiro					
		id_regra = Integer.parseInt(strId[0]); 
	}
	
	private void limpaCampos() {
		txtMatricula.setText("");
	}
}
