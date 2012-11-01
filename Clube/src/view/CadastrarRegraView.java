package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CadastrarRegraView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblSegunda;
	private JCheckBox cbxSegunda;
	private JLabel lblTerca;
	private JCheckBox cbxTerca;
	private JLabel lblQuarta;
	private JCheckBox cbxQuarta;
	private JLabel lblQuinta;
	private JCheckBox cbxQuinta;
	private JLabel lblSexta;
	private JCheckBox cbxSexta;
	private JLabel lblSabado;
	private JCheckBox cbxSabado;
	private JLabel lblDomingo;
	private JCheckBox cbxDomingo;
	
	private JPanel panel;
	
	private JButton cadastrar;
	private JButton cancelar;
	
	private void montaTela() {

		setTitle("SysClub - Cadastra Funcionário");

		lblSegunda = new JLabel();
		lblSegunda.setText("Seg:");
		cbxSegunda = new JCheckBox();

		lblTerca = new JLabel();
		lblTerca.setText("Ter:");
		cbxTerca = new JCheckBox();
		
		lblQuarta = new JLabel();
		lblQuarta.setText("Qua:");
		cbxQuarta = new JCheckBox();
		
		lblQuinta = new JLabel();
		lblQuinta.setText("Qui:");
		cbxQuinta = new JCheckBox();
		
		lblSexta = new JLabel();
		lblSexta.setText("Sex:");
		cbxSexta = new JCheckBox();
		
		lblSabado = new JLabel();
		lblSabado.setText("Sab:");
		cbxSabado = new JCheckBox();
		
		lblDomingo = new JLabel();
		lblDomingo.setText("Dom:");
		cbxDomingo = new JCheckBox();
		
		cadastrar = new JButton("Cadastrar");
		cancelar = new JButton("Cancelar");
		this.getRootPane().setDefaultButton(cadastrar); 
		
		panel = new JPanel(new GridLayout(7, 1));
		panel.add(lblSegunda);
		panel.add(cbxSegunda);
		panel.add(lblTerca);
		panel.add(cbxTerca);
		panel.add(lblQuarta);
		panel.add(cbxQuarta);
		panel.add(lblQuinta);
		panel.add(cbxQuinta);
		panel.add(lblSexta);
		panel.add(cbxSexta);
		panel.add(lblSabado);
		panel.add(cbxSabado);
		panel.add(lblDomingo);
		panel.add(cbxDomingo);
		

		
		add(panel, BorderLayout.CENTER);
	}
	
	
}
