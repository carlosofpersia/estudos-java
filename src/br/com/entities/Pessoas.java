/**
 * 
 */
package br.com.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author carlossantos
 *
 */
public class Pessoas implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1729402487078946586L;
	
	private int idPessoa = 0;
	private int idade = 0;
	private String nome = "";
	private String sobrenome = "";
	
	private Set<Eventos> eventos = new HashSet<Eventos>();

	/**
	 * 
	 */
	public Pessoas() {
		// TODO Auto-generated constructor stub
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Set<Eventos> getEventos() {
		return eventos;
	}

	public void setEventos(Set<Eventos> eventos) {
		this.eventos = eventos;
	}
}
