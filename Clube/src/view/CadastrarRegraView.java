package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import dao.DiasDaSemanaDAO;
import dao.RegraDAO;
import es2.atividade2.model.DiasDaSemana;
import es2.atividade2.model.Regra;

public class CadastrarRegraView extends JFrame implements ItemListener {

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

	boolean monday = true;
	boolean tuesday = true;
	boolean wednesday = true;
	boolean thursday = true;
	boolean friday = true;
	boolean saturday = true;
	boolean sunday = true;

	
	private JLabel lblNomeCartao;
	private JLabel lblHoraInicial;
	private JLabel lblHoraFinal;
	private JLabel lblNumeroAcessoDia;
	private JLabel lblValor;
	private JTextField txtNomeCartao;
	private JTextField txtHoraInicial;
	private JTextField txtHoraFinal;
	private JTextField txtNumeroAcessoDia;
	private JTextField txtValor;
	
	String nomeCartao;
	String horaInicial;
	String horaFinal;
	String numeroAcessoDia;
	Double valor;
	
	private JPanel panel;

	private JButton cadastrar;
	private JButton cancelar;

	public CadastrarRegraView() {
		montaTela();
		acaoBotaoCadastrar();
	}

	private void montaTela() {

		setTitle("SysClub - Cadastra Regra");

		cbxSegunda = new JCheckBox("Segunda");
		cbxSegunda.setMnemonic(KeyEvent.VK_S);
		cbxSegunda.setSelected(true);
		cbxSegunda.addItemListener(this);

		cbxTerca = new JCheckBox("Terça");
		cbxTerca.setMnemonic(KeyEvent.VK_T);
		cbxTerca.setSelected(true);
		cbxTerca.addItemListener(this);

		cbxQuarta = new JCheckBox("Quarta");
		cbxQuarta.setMnemonic(KeyEvent.VK_Q);
		cbxQuarta.setSelected(true);
		cbxQuarta.addItemListener(this);

		cbxQuinta = new JCheckBox("Quinta");
		cbxQuinta.setMnemonic(KeyEvent.VK_U);
		cbxQuinta.setSelected(true);
		cbxQuinta.addItemListener(this);

		cbxSexta = new JCheckBox("Sexta");
		cbxSexta.setMnemonic(KeyEvent.VK_E);
		cbxSexta.setSelected(true);
		cbxSexta.addItemListener(this);

		cbxSabado = new JCheckBox("Sábado");
		cbxSabado.setMnemonic(KeyEvent.VK_A);
		cbxSabado.setSelected(true);
		cbxSabado.addItemListener(this);

		cbxDomingo = new JCheckBox("Domingo");
		cbxDomingo.setMnemonic(KeyEvent.VK_D);
		cbxDomingo.setSelected(true);
		cbxDomingo.addItemListener(this);

		lblNomeCartao = new JLabel();
		lblNomeCartao.setText("Nome do Cartão:");
		txtNomeCartao = new JTextField(15);
		
		lblHoraInicial = new JLabel();
		lblHoraInicial.setText("Hora Inicial:");
		txtHoraInicial = new JTextField(15);
		
		lblHoraFinal = new JLabel();
		lblHoraFinal.setText("Hora Final:");
		txtHoraFinal = new JTextField(15);
		
		lblNumeroAcessoDia = new JLabel();
		lblNumeroAcessoDia.setText("Nº Acesso/Dia:");
		txtNumeroAcessoDia = new JTextField(15);
		
		lblValor = new JLabel();
		lblValor.setText("Valor:");
		txtValor = new JTextField(15);
		
		cadastrar = new JButton("Cadastrar");
		cancelar = new JButton("Cancelar");
		this.getRootPane().setDefaultButton(cadastrar);

		JPanel fundo = new JPanel();
		
		
		JPanel checkPanel = new JPanel(new GridLayout(4, 2));
		checkPanel.setBorder(new TitledBorder("Dias Da Semana"));
		checkPanel.add(cbxSegunda);
		checkPanel.add(cbxTerca);
		checkPanel.add(cbxQuarta);
		checkPanel.add(cbxQuinta);
		checkPanel.add(cbxSexta);
		checkPanel.add(cbxSabado);
		checkPanel.add(cbxDomingo);
		
		fundo.add(checkPanel, BorderLayout.WEST);
		
		panel = new JPanel(new GridLayout(7, 2));
		panel.setBorder(new TitledBorder("Regra"));
		panel.add(lblNomeCartao);
		panel.add(txtNomeCartao);
		panel.add(lblHoraInicial);
		panel.add(txtHoraInicial);
		panel.add(lblHoraFinal);
		panel.add(txtHoraFinal);
		panel.add(lblNumeroAcessoDia);
		panel.add(txtNumeroAcessoDia);
		panel.add(lblValor);
		panel.add(txtValor);

		
		fundo.add(panel, BorderLayout.EAST);
		fundo.add(cadastrar);
		fundo.add(cancelar);
		add(fundo);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		int index = 0;
		Object source = e.getItemSelectable();
		

		if (source == cbxSegunda) {
			index = 0;
			monday = false;
		} else if (source == cbxTerca) {
			index = 1;
			tuesday = false;
		} else if (source == cbxQuarta) {
			index = 2;
			wednesday = false;
		} else if (source == cbxQuinta) {
			index = 3;
			thursday = false;
		} else if (source == cbxSexta) {
			index = 4;
			friday = false;
		} else if (source == cbxSabado) {
			index = 5;
			saturday = false;
		} else if (source == cbxDomingo) {
			index = 6;
			sunday = false;
		}
	}

	private void acaoBotaoCadastrar() {

		cadastrar.addActionListener(new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					DiasDaSemanaDAO diasDaSemanaDAO = new DiasDaSemanaDAO();
					DiasDaSemana u = new DiasDaSemana(1, monday, tuesday, wednesday,
							thursday, friday, saturday, sunday);
					diasDaSemanaDAO.conectar();
					diasDaSemanaDAO.insert(u);	
					DiasDaSemana d = diasDaSemanaDAO.select(diasDaSemanaDAO.getUltimoId());
					diasDaSemanaDAO.desconectar();
					
					getCampos();
					
					
					RegraDAO regraDAO = new RegraDAO();
					 
					Regra r = new Regra(1, nomeCartao, horaInicial, horaFinal, d, numeroAcessoDia, valor);
					regraDAO.conectar();
					regraDAO.insert(r);
					regraDAO.desconectar();					
					
					JOptionPane.showMessageDialog(null,
							"Regra cadastrada com Sucesso", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,
							"Não foi possível cadsatrar a Regra", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}
	
	private void getCampos() {
		nomeCartao = txtNomeCartao.getText();
		horaInicial = txtHoraInicial.getText();
		horaFinal = txtHoraFinal.getText();//Integer.parseInt(txtIdade.getText());
		numeroAcessoDia = txtNumeroAcessoDia.getText();
		valor = Double.parseDouble(txtValor.getText());

	}
}
