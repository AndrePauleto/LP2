package es2.atividade2.model;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import dao.LogDAO;

public class Socio extends Pessoa{

	private Cartao cartao;
	private Set<Log> log = new HashSet<Log>();

	public Socio(int id, String nome, String morada, int idade, Cartao cartao) {
		super(id, nome, morada, idade);
		setCartao(cartao);
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public boolean acessarGinasio() throws ParseException {
		boolean acessando = getCartao().isAcessando();
		if (acessando != true) {
			if (validarAcesso()) {
				getCartao().setAcessando(true);
				
				LogDAO logDao = new LogDAO();
				logDao.conectar();
				Log u = new Log(this);
				logDao.insert(u);
				log.add(u);	
				logDao.desconectar();		
							
				return true;
			}
		}else{
			sairGinasio();			
		}
		return false;
	}
	
	public void sairGinasio(){
		getCartao().setAcessando(false);
		log.add(new Log(this));
		
	}

	private boolean validarAcesso() throws ParseException {
		if (verificaHora()) {
			if (verificaDiaDaSemana()) {
				if (verificaQuantidadePorDia()) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean verificaHora() throws ParseException {

		String horaInicialStr = getCartao().getRegra().getHoraInicial();
		String horaFinalStr = getCartao().getRegra().getHoraFinal();

		SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
		Date data = formatador.parse(horaInicialStr);
		Time horaInicial = new Time(data.getTime());

		data = formatador.parse(horaFinalStr);
		Time horaFinal = new Time(data.getTime());

		Date HoraSistema = new Date();
		int hora = HoraSistema.getHours();
		int minutos = HoraSistema.getMinutes();
		String horaAtualStr = hora + ":" + minutos;
		data = formatador.parse(horaAtualStr);
		Time horaAtual = new Time(data.getTime());

		if ((horaAtual.compareTo(horaInicial) == 1)
				&& (horaAtual.compareTo(horaFinal) == -1)) {
			return true;
		}
		return false;
	}

	private boolean verificaDiaDaSemana() {

		boolean segunda = getCartao().getRegra().getDiasDaSemana().isMonday();
		boolean terca = getCartao().getRegra().getDiasDaSemana().isTuesday();
		boolean quarta = getCartao().getRegra().getDiasDaSemana().isWednesday();
		boolean quinta = getCartao().getRegra().getDiasDaSemana().isThursday();
		boolean sexta = getCartao().getRegra().getDiasDaSemana().isFriday();
		boolean sabado = getCartao().getRegra().getDiasDaSemana().isSaturday();
		boolean domingo = getCartao().getRegra().getDiasDaSemana().isSaturday();

		Calendar objCalendar = Calendar.getInstance();
		Locale objLocale = new Locale("pt", "BR");
		String diaDaSemanaAtual = objCalendar.getDisplayName(
				Calendar.DAY_OF_WEEK, Calendar.LONG, objLocale);

		if (segunda) {
			if (diaDaSemanaAtual == "Segunda-feira")
				return true;
		}
		if (terca) {
			if (diaDaSemanaAtual == "Terça-feira")
				return true;
		}
		if (quarta) {
			if (diaDaSemanaAtual == "Quarta-feira")
				return true;
		}
		if (quinta) {
			if (diaDaSemanaAtual == "Quinta-feira")
				return true;
		}
		if (sexta) {
			if (diaDaSemanaAtual == "Sexta-feira")
				return true;
		}
		if (sabado) {
			if (diaDaSemanaAtual == "Sábado")
				return true;
		}
		if (domingo) {
			if (diaDaSemanaAtual == "Domingo")
				return true;
		}

		return false;
	}

	private boolean verificaQuantidadePorDia() {

		Date dataAtual = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String dataAtualStr = formato.format(dataAtual);
		int quantidadePorDia = 0;
		String numeroAcessoDia = getCartao().getRegra().getNumeroAcessoDia();

		if (numeroAcessoDia == "0") {
			return true;
		}

		if (log != null) {
			for (Log l : log) {
				String dataLog = l.getData();
				if (dataAtualStr.equals(dataLog)) {
					quantidadePorDia++;
				}
			}
		}

		if (quantidadePorDia <= Integer.parseInt(numeroAcessoDia)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Socio [cartao=" + cartao + ", log=" + log + ", Nome="
				+ getNome() + ", Morada=" + getMorada() + ", Idade="
				+ getIdade() + "]";
	}




	
}
