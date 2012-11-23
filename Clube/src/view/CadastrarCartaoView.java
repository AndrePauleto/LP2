package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Collection;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import dao.CartaoDAO;
import dao.RegraDAO;
import dao.SocioDAO;
import es2.atividade2.model.Cartao;
import es2.atividade2.model.Regra;
import es2.atividade2.model.Socio;

public class CadastrarCartaoView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel lblMatricula;
	private JTextField txtMatricula;
	private JLabel lblNome;
	private JTextField txtNome;
	private JLabel lblMorada;
	private JTextField txtMorada;
	private JLabel lblIdade;
	private JTextField txtIdade;
	private JLabel lblRegra;
	private JComboBox cmbxRegra = new JComboBox();

	private JPanel panel;
	private JPanel panelBotoes;
	private JPanel panelSocio;
	private JButton cadastrar;
	private JButton cancelar;

	String matricula;
	int id_regra;
	String nome;
	String morada;
	int idade;

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

		lblNome = new JLabel();
		lblNome.setText("Nome:");
		txtNome = new JTextField(15);

		lblMorada = new JLabel();
		lblMorada.setText("Morada:");
		txtMorada = new JTextField(15);

		lblIdade = new JLabel();
		lblIdade.setText("Idade:");
		txtIdade = new JTextField(15);

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

		panelSocio = new JPanel(new GridLayout(6, 3));
		panelSocio.setBorder(new TitledBorder("Sócio"));

		panel.add(lblMatricula);
		panel.add(txtMatricula);
		panel.add(lblRegra);
		panel.add(cmbxRegra);
		panelSocio.add(lblNome);
		panelSocio.add(txtNome);
		panelSocio.add(lblMorada);
		panelSocio.add(txtMorada);
		panelSocio.add(lblIdade);
		panelSocio.add(txtIdade);
		panelBotoes.add(cadastrar);
		panelBotoes.add(cancelar);
		add(panel, "North");
		add(panelSocio, "Center");
		add(panelBotoes, "South");

	}

	private void botaoCadastar() {
		cadastrar.addActionListener(new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {

				getCampos();

				if (validaCampos()) {

					RegraDAO regraDAO = new RegraDAO();
					CartaoDAO cartaoDAO = new CartaoDAO();
					cartaoDAO.conectar();
					regraDAO.conectar();

					// seleciona regra através da combo
					Regra r = regraDAO.select(id_regra);
					// Insere Cartao
					Cartao u = new Cartao(1, matricula, r, false);
					cartaoDAO.insert(u);

					// Recebe o ultimo objeto Cartão inserido
					Cartao cartao = cartaoDAO.select(cartaoDAO.getUltimoId());
					regraDAO.desconectar();
					cartaoDAO.desconectar();

					// Insere Sócio
					SocioDAO socioDAO = new SocioDAO();
					socioDAO.conectar();
					Socio s = new Socio(1, nome, morada, idade, cartao);
					socioDAO.insert(s);
					socioDAO.desconectar();

					limpaCampos();

					JOptionPane.showMessageDialog(null,
							"Cartão cadastrado com Sucesso", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

	}

	private void getCampos() {
		matricula = txtMatricula.getText();

		// recebe valor da combo box
		String cmbxSelecionado = (String) cmbxRegra.getSelectedItem();

		// Utiliza o "-" como separador para obeter a String ID
		String[] strId = cmbxSelecionado.split(" -");

		// Converte este String ID para inteiro
		id_regra = Integer.parseInt(strId[0]);

		nome = txtNome.getText();
		morada = txtMorada.getText();
		idade = Integer.parseInt(txtIdade.getText());
	}

	private boolean validaCampos() {

		CartaoDAO cartaoDao = new CartaoDAO();
		cartaoDao.conectar();

		Collection<Cartao> c = cartaoDao.select();
		for (Cartao cartao : c) {

			if (matricula.equals(cartao.getMatricula())) {
				JOptionPane.showMessageDialog(null, "Matrícula já existe.",
						"Aviso", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
		}
		cartaoDao.desconectar();

		return true;

	}

	private void limpaCampos() {
		txtMatricula.setText("");
		txtNome.setText("");
		txtMorada.setText("");
		txtIdade.setText("");
	}
}
