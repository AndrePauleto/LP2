package es2.atividade2.model;

public class Regra {
	
	private String nomeCartao;
	private String horaInicial;
	private String horaFinal;
	private DiasDaSemana diasDaSemana;
	private String numeroAcessoDia;
	private double valor;
	private int id;
	
	
	public Regra(int id, String nomeCartao, String horaInicial, String horaFinal,
			DiasDaSemana diasDaSemana, String numeroAcessoDia, double valor) {
		super();
		setId(id);
		setNomeCartao(nomeCartao);
		setHoraInicial(horaInicial);
		setHoraFinal(horaFinal);
		setDiasDaSemana(diasDaSemana);
		setNumeroAcessoDia(numeroAcessoDia);
		setValor(valor);
	}
	
	public String getNomeCartao() {
		return nomeCartao;
	}
	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}
	public String getHoraInicial() {
		return horaInicial;
	}
	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}
	public String getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}
	public DiasDaSemana getDiasDaSemana() {
		return diasDaSemana;
	}
	public void setDiasDaSemana(DiasDaSemana diasDaSemana) {
		this.diasDaSemana = diasDaSemana;
	}
	public String getNumeroAcessoDia() {
		return numeroAcessoDia;
	}
	public void setNumeroAcessoDia(String numeroAcessoDia) {
		this.numeroAcessoDia = numeroAcessoDia;
	}	

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	


	@Override
	public String toString() {
		return "Regra [nomeCartao=" + nomeCartao + ", horaInicial="
				+ horaInicial + ", horaFinal=" + horaFinal + ", diasDaSemana="
				+ diasDaSemana + ", numeroAcessoDia=" + numeroAcessoDia
				+ ", valor=" + valor + "]";
	}


	
	
}
