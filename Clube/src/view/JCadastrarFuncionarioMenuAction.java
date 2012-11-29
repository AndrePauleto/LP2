package view;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

public class JCadastrarFuncionarioMenuAction {
	public static final String DEPOSITAR1 = "DEPOSITAR1";

	private JPanel principal;
	private CardLayout cards;
	
	public JCadastrarFuncionarioMenuAction(JPanel principal, CardLayout cards) {
		
		this.principal = principal;
		this.cards = cards;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		cards.show(principal, DEPOSITAR1);
	}
}
