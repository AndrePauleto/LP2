package view;

import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import swing.action.JDepositarMenuAction;

public class FuncionarioView extends JFrame {

	private static final long serialVersionUID = 1L;

	CardLayout cards = new CardLayout();	
	JPanel principal = new JPanel(cards);
	
	public FuncionarioView() {

		setJMenuBar(Menu());
		fecharJanela();
	}

	private void fecharJanela() {

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (e.getID() == WindowEvent.WINDOW_CLOSING) {

					if (JOptionPane.showConfirmDialog(null,
							"Deseja sair do programa", "Info Sys",
							JOptionPane.YES_NO_OPTION) == 0) {
						LoginView frame = new LoginView();
						frame.setSize(300, 100);
						frame.setLocationRelativeTo(null);
						frame.setIconImage(Toolkit.getDefaultToolkit()
								.getImage("icone.jpeg"));
						frame.setVisible(true);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

						dispose();
					} else {
						setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
					}
				}
			}

		});
	}

	private JMenuBar Menu() {
		JMenuBar menuBar = new JMenuBar();
		JMenuItem item;
		JMenu menu;
		JPanel funcionario = new CadastrarFuncionarioView(principal, cards);
		principal.add(funcionario, JCadastrarFuncionarioMenuAction.DEPOSITAR1);
		
		menu = new JMenu("Arquivo");

		item = new JMenuItem("Principal");
		item.addActionListener(new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Em desenvolvimento.. ",
						"Aviso", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		menu.add(item);

		item = new JMenuItem("Sair");
		item.addActionListener(new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(null,
						"Deseja sair do programa", "Info Sys",
						JOptionPane.YES_NO_OPTION) == 0) {

					LoginView frame = new LoginView();
					frame.setSize(300, 100);
					frame.setLocationRelativeTo(null);
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
							"icone.jpeg"));
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					dispose();
				}
			}
		});

		menu.add(item);
		menuBar.add(menu);

		menu = new JMenu("Cadastrar");
		item = new JMenuItem(new AbstractAction("Funcionário") {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {				
				//CadastrarFuncionarioView cadastrarFuncionarioView = new CadastrarFuncionarioView();
				//cadastrarFuncionarioView.setSize(350, 320);
				//cadastrarFuncionarioView.setLocationRelativeTo(null);
				//cadastrarFuncionarioView.setIconImage(Toolkit
						//.getDefaultToolkit().getImage("icone.jpeg"));
				//cadastrarFuncionarioView.setVisible(true);
								
				cards.show(principal, "Funcionario");

				// cadastrarFuncionarioView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}
		});
		menu.add(item);

		item = new JMenuItem("Regra");
		item.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				CadastrarRegraView cadastrarRegraView = new CadastrarRegraView();
				cadastrarRegraView.setSize(560, 280);
				cadastrarRegraView.setLocationRelativeTo(null);
				cadastrarRegraView.setIconImage(Toolkit.getDefaultToolkit()
						.getImage("icone.jpeg"));
				cadastrarRegraView.setVisible(true);

			}
		});
		menu.add(item);

		item = new JMenuItem("Sócio");
		item.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				CadastrarCartaoView cadastrarCartaoView = new CadastrarCartaoView();
				cadastrarCartaoView.setSize(350, 380);
				cadastrarCartaoView.setLocationRelativeTo(null);
				cadastrarCartaoView.setIconImage(Toolkit.getDefaultToolkit()
						.getImage("icone.jpeg"));
				cadastrarCartaoView.setVisible(true);

			}
		});
		menu.add(item);

		menuBar.add(menu);

		menu = new JMenu("Editar");
		item = new JMenuItem("Funcionário");
		item.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				EditarFuncionarioView editarFuncionarioView = new EditarFuncionarioView();
				editarFuncionarioView.setSize(650, 380);
				editarFuncionarioView.setLocationRelativeTo(null);
				editarFuncionarioView.setIconImage(Toolkit.getDefaultToolkit()
						.getImage("icone.jpeg"));
				editarFuncionarioView.setVisible(true);
			}
		});
		menu.add(item);

		item = new JMenuItem("Regra");
		item.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				EditarRegraView editarRegraView = new EditarRegraView();
				editarRegraView.setSize(650, 380);
				editarRegraView.setLocationRelativeTo(null);
				editarRegraView.setIconImage(Toolkit.getDefaultToolkit()
						.getImage("icone.jpeg"));
				editarRegraView.setVisible(true);
			}
		});
		menu.add(item);

		item = new JMenuItem("Cartão");
		item.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				EditarCartaoView editarCartaoView = new EditarCartaoView();
				editarCartaoView.setSize(650, 380);
				editarCartaoView.setLocationRelativeTo(null);
				editarCartaoView.setIconImage(Toolkit.getDefaultToolkit()
						.getImage("icone.jpeg"));
				editarCartaoView.setVisible(true);

			}
		});
		menu.add(item);

		item = new JMenuItem("Sócio");
		item.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				EditarSocioView editarSocioView = new EditarSocioView();
				editarSocioView.setSize(650, 380);
				editarSocioView.setLocationRelativeTo(null);
				editarSocioView.setIconImage(Toolkit.getDefaultToolkit()
						.getImage("icone.jpeg"));
				editarSocioView.setVisible(true);

			}
		});

		menu.add(item);
		menuBar.add(menu);

		menu = new JMenu("Ajuda");

		item = new JMenuItem("Sobre");
		item.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(
								null,
								"Sistema de Controle de Acesso a Clube \nVersão: 1.0 \nFeito por: André Pauleto Mello",
								"Sobre", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		menu.add(item);

		menuBar.add(menu);
		return menuBar;
	}

}
