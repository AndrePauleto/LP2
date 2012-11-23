package es2.atividade2.model;

public class Funcionario extends Pessoa {

	private String login;
	private String senha;

	public Funcionario(int id, String nome, String morada, int idade,
			String login, String senha) {
		super(id, nome, morada, idade);
		setLogin(login);
		setSenha(senha);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Funcionario [login=" + login + ", senha=" + senha + ", Nome="
				+ getNome() + ", Morada=" + getMorada() + ", Idade="
				+ getIdade() + "]";
	}

}
