package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

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


public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton SUBMIT;
	private JPanel panel;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	final JTextField txtUsuario, txtSenha;
	

	LoginView() {
		lblUsuario = new JLabel();
		lblUsuario.setText("Usuário:");
		txtUsuario = new JTextField(15);

		lblSenha = new JLabel();
		lblSenha.setText("Senha:");
		txtSenha = new JPasswordField(15);

		SUBMIT = new JButton("SUBMIT");
		this.getRootPane().setDefaultButton(SUBMIT);
		
		panel = new JPanel(new GridLayout(3, 1));
		panel.add(lblUsuario);
		panel.add(txtUsuario);
		panel.add(lblSenha);
		panel.add(txtSenha);
		panel.add(SUBMIT);
		add(panel, BorderLayout.CENTER);
		
		SUBMIT.addActionListener(new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario = txtUsuario.getText();
				String senha = txtSenha.getText();	
				boolean flag = false;
				
				FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
				funcionarioDAO.conectar();
				List<Funcionario> funcionarios =  new ArrayList<Funcionario>(funcionarioDAO.select());
				funcionarioDAO.desconectar();
				
				for (Funcionario f : funcionarios) {					
					if(usuario.equals(f.getLogin())&& senha.equals(f.getSenha())){						
						flag = true;
						break;
					}						
				}			
				
				if (flag) {
										
					FuncionarioView funcionarioView = new FuncionarioView();					
					funcionarioView.setSize(600, 480);
					funcionarioView.setIconImage(Toolkit.getDefaultToolkit()
							  .getImage("icone.jpeg"));
					funcionarioView.setVisible(true);					
					funcionarioView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							
				} else {					
					JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos",
							"Error", JOptionPane.ERROR_MESSAGE);					
				}
			}
		});
		
		setTitle("SysClub - Login");
	}


	public static void main(String arg[]) {
		try {
			LoginView frame = new LoginView();
			frame.setSize(300, 100);
			frame.setIconImage(Toolkit.getDefaultToolkit()
					  .getImage("icone.jpeg"));
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
