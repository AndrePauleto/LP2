package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AcessoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private String msg;
	private JLabel mensagem;
	
	public AcessoView(String msg) {
		setMsg(msg);
		mensagem = new JLabel(msg);
		
		add(mensagem, BorderLayout.CENTER);
		
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
