package br.com.entities;

import java.io.Serializable;
import java.util.Date;

public class Eventos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1661743204601734614L;
	private int idEvento = 0;
	private String evento = "";
	private Date dataHora = new Date();

	public Eventos() {
		//
	}
	
	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento( int idEvento ) {
		this.idEvento = idEvento;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
}
