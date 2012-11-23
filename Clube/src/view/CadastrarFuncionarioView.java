package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.FuncionarioDAO;
import es2.atividade2.model.Funcionario;

public class CadastrarFuncionarioView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton cadastrar;
	private JButton cancelar;
	private JPanel panel;
	private JLabel lblNome;
	private JLabel lblMorada;
	private JLabel lblIdade;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JTextField txtNome;
	private JTextField txtMorada;
	private JTextField txtIdade;
	private JTextField txtUsuario;
	private JTextField txtSenha;
	private String nome;
	private String morada;
	private int idade;
	private String login;
	private String senha;

	public CadastrarFuncionarioView() {
		montaTela();
		acaoBotaoCadastrar();
		acaoBotaoCancelar();
	}

	private void montaTela() {

		setTitle("SysClub - Cadastra Funcionário");

		lblNome = new JLabel();
		lblNome.setText("Nome:");
		txtNome = new JTextField(15);

		lblMorada = new JLabel();
		lblMorada.setText("Morada:");
		txtMorada = new JTextField(15);

		lblIdade = new JLabel();
		lblIdade.setText("Idade:");
		txtIdade = new JTextField(15);

		lblUsuario = new JLabel();
		lblUsuario.setText("Usuário:");
		txtUsuario = new JTextField(15);

		lblSenha = new JLabel();
		lblSenha.setText("Senha:");
		txtSenha = new JPasswordField(15);

		cadastrar = new JButton("Cadastrar");
		cancelar = new JButton("Cancelar");
		this.getRootPane().setDefaultButton(cadastrar);

		panel = new JPanel(new GridLayout(6, 1));
		panel.add(lblNome);
		panel.add(txtNome);
		panel.add(lblMorada);
		panel.add(txtMorada);
		panel.add(lblIdade);
		panel.add(txtIdade);
		panel.add(lblUsuario);
		panel.add(txtUsuario);
		panel.add(lblSenha);
		panel.add(txtSenha);
		panel.add(cadastrar);
		panel.add(cancelar);
		add(panel, BorderLayout.CENTER);
	}

	private void acaoBotaoCadastrar() {
		cadastrar.addActionListener(new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					getCampos();

					FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
					funcionarioDAO.conectar();
					Funcionario f = new Funcionario(1, nome, morada, idade,
							login, senha);
					funcionarioDAO.insert(f);
					funcionarioDAO.desconectar();

					limpaCampos();

					JOptionPane.showMessageDialog(null,
							"Funcionário Cadastrado com Sucesso", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception e2) {

					JOptionPane.showMessageDialog(null,
							"Não foi possível cadsatrar funcionário", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

	private void acaoBotaoCancelar() {

		cancelar.addActionListener(new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});

	}

	private void getCampos() {
		nome = txtNome.getText();
		morada = txtMorada.getText();
		idade = Integer.parseInt(txtIdade.getText());
		login = txtUsuario.getText();
		senha = txtSenha.getText();
	}

	private void limpaCampos() {
		txtNome.setText("");
		txtMorada.setText("");
		txtIdade.setText("");
		txtUsuario.setText("");
		txtSenha.setText("");
	}

}
