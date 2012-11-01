package es2.atividade2.model;

public class Cartao {
		
	private String matricula;
	private Regra regra;
	private boolean acessando;
	private int id;
	
	public Cartao(int id, String matricula, Regra regra, boolean acessando) {
		super();
		setId(id);
		setMatricula(matricula);
		setRegra(regra);
		setAcessando(acessando);
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Regra getRegra() {
		return regra;
	}

	public void setRegra(Regra regra) {
		this.regra = regra;
	}	
	
	public boolean isAcessando() {
		return acessando;
	}

	public void setAcessando(boolean acessando) {
		this.acessando = acessando;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Cartao [matricula=" + matricula + ", regra=" + regra
				+ ", acessando=" + acessando + "]";	}



	
	
}
