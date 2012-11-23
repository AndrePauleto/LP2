package es2.atividade2.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

	private Socio socio;
	private Date dataHora;
	private String data;
	private String hora;
	private int id;

	public Log(Socio socio) {
		setSocio(socio);
		this.dataHora = new Date();
		formataData();
		formataHora();
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public String getData() {
		return data;
	}

	public String getHora() {
		return hora;
	}

	public void formataData() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		data = formato.format(dataHora);
	}

	public void formataHora() {
		SimpleDateFormat hr = new SimpleDateFormat("hh:mm");
		hora = hr.format(dataHora);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
