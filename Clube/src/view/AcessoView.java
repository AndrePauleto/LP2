package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AcessoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private String msg;
	private JLabel mensagem;

	public AcessoView(String msg, Color c) {

		setVisible(true);
		setSize(410, 300);
		setMsg(msg);
		mensagem = new JLabel(msg);
		mensagem.setFont(new Font("Arial", Font.BOLD, 26));
		mensagem.setForeground(Color.white);

		add(mensagem, BorderLayout.CENTER);
		getContentPane().setBackground(c);

	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
