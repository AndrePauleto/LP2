package view;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class FuncionarioView extends JFrame {

	private static final long serialVersionUID = 1L;

	public FuncionarioView() {

		setJMenuBar(Menu());
	}

	private JMenuBar Menu() {
		JMenuBar menuBar = new JMenuBar();
		JMenuItem item;
		JMenu menu;

		menu = new JMenu("Arquivo");

		item = new JMenuItem("Principal");
		item.addActionListener(new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

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
					dispose();
				}
			}
		});

		menu.add(item);
		menuBar.add(menu);

		menu = new JMenu("Cadastrar");
		item = new JMenuItem(new AbstractAction("Funcion�rio") {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				CadastrarFuncionarioView cadastrarFuncionarioView = new CadastrarFuncionarioView();
				cadastrarFuncionarioView.setSize(350, 200);
				cadastrarFuncionarioView.setIconImage(Toolkit
						.getDefaultToolkit().getImage("icone.jpeg"));
				cadastrarFuncionarioView.setVisible(true);
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
				cadastrarRegraView.setSize(620, 280);
				cadastrarRegraView.setIconImage(Toolkit.getDefaultToolkit()
						.getImage("icone.jpeg"));
				cadastrarRegraView.setVisible(true);

			}
		});
		menu.add(item);

		item = new JMenuItem("S�cio");
		item.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				CadastrarCartaoView cadastrarCartaoView = new CadastrarCartaoView();
				cadastrarCartaoView.setSize(350, 380);
				cadastrarCartaoView.setIconImage(Toolkit.getDefaultToolkit()
						.getImage("icone.jpeg"));
				cadastrarCartaoView.setVisible(true);

			}
		});
		menu.add(item);

		menuBar.add(menu);

		menu = new JMenu("Editar");
		item = new JMenuItem("Funcion�rio");
		item.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				EditarFuncionarioView editarFuncionarioView = new EditarFuncionarioView();
				editarFuncionarioView.setSize(350, 380);
				editarFuncionarioView.setIconImage(Toolkit.getDefaultToolkit()
						.getImage("icone.jpeg"));
				// fica no meio da tela
				// editarFuncionarioView.setLocationRelativeTo(null);
				editarFuncionarioView.setVisible(true);
			}
		});
		menu.add(item);

		item = new JMenuItem("Regra");
		item.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		menu.add(item);

		item = new JMenuItem("Cart�o");
		item.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		menu.add(item);

		item = new JMenuItem("S�cio");
		item.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

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
								"Sistema de Controle de Acesso a Clube \nVers�o: 1.0 \nFeito por: Andr� Pauleto Mello",
								"Sobre", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		menu.add(item);

		menuBar.add(menu);
		return menuBar;
	}

}
