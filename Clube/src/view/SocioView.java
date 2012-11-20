package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.SocioDAO;
import es2.atividade2.model.Socio;

public class SocioView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JLabel lblMatricula;
	private JTextField txtMatricula;
	private JButton acessar;
	Socio socioSelecionado;
	private String msg;
	private Color c;

	public SocioView() {

		lblMatricula = new JLabel();
		lblMatricula.setText("Matricula:");
		txtMatricula = new JTextField(15);

		acessar = new JButton("Acessar");
		this.getRootPane().setDefaultButton(acessar);

		panel = new JPanel(new GridLayout(2, 1));
		panel.add(lblMatricula);
		panel.add(txtMatricula);
		add(panel, BorderLayout.CENTER);
		add(acessar, BorderLayout.SOUTH);
		acessar.addActionListener(new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				String socio = txtMatricula.getText();

				boolean flag = false;

				SocioDAO socioDAO = new SocioDAO();
				socioDAO.conectar();
				List<Socio> socios = new ArrayList<Socio>(socioDAO.select());
				socioDAO.desconectar();

				for (Socio s : socios) {
					if (socio.equals(s.getCartao().getMatricula())) {
						System.out.println(s);
						flag = true;
						socioSelecionado = s;
						break;
					}
				}

				System.out.println(socioSelecionado);

				if (flag) {

					if (!socioSelecionado.getCartao().isAcessando()) {
						try {
							if (socioSelecionado.acessarGinasio()) {
								msg = "Acesso Liberado: Bem-Vindo";
								c = Color.green;
							} else {
								msg = "Acesso Negado";
								c = Color.red;
							}
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						socioSelecionado.sairGinasio();
						msg = "Acesso Liberado: Volte Sempre";
						c = Color.green;
					}

					AcessoView acessoView = new AcessoView(msg, c);	
					
					//acessoView.setVisible(false);

				} else {
					JOptionPane.showMessageDialog(null, "Matricula incorreta",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		setTitle("SysClub - Login");

	}

	public static void main(String arg[]) {
		try {
			SocioView frame = new SocioView();
			frame.setSize(300, 100);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
