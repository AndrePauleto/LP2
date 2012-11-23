package es2.atividade2.model;

import java.text.ParseException;

public class Ginasio {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		DiasDaSemana Todos = new DiasDaSemana(1, true, true, true, true, true,
				true, true);
		/*DiasDaSemana STQQS = new DiasDaSemana(1, true, true, true, true, true,
				false, false);*/
		/*DiasDaSemana STQQ = new DiasDaSemana(1, true, true, true, true, false,
				false, false);*/
		DiasDaSemana STQ = new DiasDaSemana(1, true, true, true, false, false,
				false, false);

		Regra Premium = new Regra(1,"Premium", "09:00", "23:00", Todos, "Ilimitado", 50.00);
		//Regra Gold = new Regra(2,"Gold", "11:00", "20:00", STQQS, "3", 40.00);
		//Regra Silver = new Regra(3,"Silver", "12:00", "18:00", STQQ, "2", 30.00);
		Regra Bronze = new Regra(4,"Bronze", "13:00", "16:00", STQ, "1", 10.00);

		Cartao cPremium = new Cartao(1, "011001/2012", Premium, false);
		Cartao cBronze = new Cartao(1, "011111/2012", Bronze, false);
		
		Socio andre = new Socio(1, "André", "Springfield", 22, cPremium);
		
		/*
		 * Cadastrando um funcionario com DAO
		 * 
		 * 
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.conectar();
		Funcionario u = new Funcionario("Andre", "Teste", 22, "andre", "123");
		funcionarioDAO.insert(u);
		funcionarioDAO.desconectar();		
		System.out.println("Funcionario cadastrado com Sucesso!");*/
		
		
		
		/*
		 Perguntar o porque não consigo acessar os métodos de Socio, já que estou instanciando
		 um objeto do tipo Socio.
		Pessoa asd = new Socio("nome", "morada", (byte) 22, cPremium);		
		asd.
		*/
				
		//primeira entrada
		if (!andre.getCartao().isAcessando()) {
			if (andre.acessarGinasio()) {
				System.out.println("Acesso Liberado - Bem-Vindo");
			} else {
				System.out.println("Acesso Negado");
			}
		}else{
			andre.sairGinasio();
			System.out.println("Acesso Liberado - Volte Sempre");
		}	
	
		//segunda vez - saida
		if (!andre.getCartao().isAcessando()) {
			if (andre.acessarGinasio()) {
				System.out.println("Acesso Liberado - Bem-Vindo");
			} else {
				System.out.println("Acesso Negado");
			}
		}else{
			andre.sairGinasio();
			System.out.println("Acesso Liberado - Volte Sempre");
		}
		
		//terceira vez entrando novamente
		if (!andre.getCartao().isAcessando()) {
			if (andre.acessarGinasio()) {
				System.out.println("Acesso Liberado - Bem-Vindo");
			} else {
				System.out.println("Acesso Negado");
			}
		}else{
			andre.sairGinasio();
			System.out.println("Acesso Liberado - Volte Sempre");
		}

		
		
		//Teste com novo objeto Socio
		Socio aline = new Socio(1, "Aline", "Teste", 22, cBronze);
		
		//primeira entrada
		if (!aline.getCartao().isAcessando()) {
			if (aline.acessarGinasio()) {
				System.out.println("Acesso Liberado - Bem-Vindo");
			} else {
				System.out.println("Acesso Negado");
			}
		}else{
			aline.sairGinasio();
			System.out.println("Acesso Liberado - Volte Sempre");
		}	
	
		//segunda vez - saida
		if (!aline.getCartao().isAcessando()) {
			if (aline.acessarGinasio()) {
				System.out.println("Acesso Liberado - Bem-Vindo");
			} else {
				System.out.println("Acesso Negado");
			}
		}else{
			aline.sairGinasio();
			System.out.println("Acesso Liberado - Volte Sempre");
		}
		
		//terceira vez entrando novamente
		if (!aline.getCartao().isAcessando()) {
			if (aline.acessarGinasio()) {
				System.out.println("Acesso Liberado - Bem-Vindo");
			} else {
				System.out.println("Acesso Negado");
			}
		}else{
			aline.sairGinasio();
			System.out.println("Acesso Liberado - Volte Sempre");
		}


	}

}
