package view;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import dao.FuncionarioDAO;
import es2.atividade2.model.Funcionario;

public class CadastrarFuncionarioView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton cadastrar;
	private JButton cancelar;
	private JPanel panelBotoes;
	private JPanel panelFuncionario;
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

	public CadastrarFuncionarioView(JPanel principal, CardLayout cards) {
		montaTela();
		acaoBotaoCadastrar();
		acaoBotaoCancelar();
	}

	private void montaTela() {		

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

		panelBotoes = new JPanel(new GridLayout(1, 2));
		panelBotoes.setBorder(new TitledBorder("Opções"));

		panelFuncionario = new JPanel(new GridLayout(10, 3));
		panelFuncionario.setBorder(new TitledBorder("Funcionário"));

		panelFuncionario.add(lblNome);
		panelFuncionario.add(txtNome);
		panelFuncionario.add(lblMorada);
		panelFuncionario.add(txtMorada);
		panelFuncionario.add(lblIdade);
		panelFuncionario.add(txtIdade);
		panelFuncionario.add(lblUsuario);
		panelFuncionario.add(txtUsuario);
		panelFuncionario.add(lblSenha);
		panelFuncionario.add(txtSenha);
		panelBotoes.add(cadastrar);
		panelBotoes.add(cancelar);

		add(panelFuncionario, "North");
		add(panelBotoes, "South");
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
