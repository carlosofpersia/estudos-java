package br.com.entities;

import java.io.Serializable;
import java.util.Date;

public class Categoria implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1603536736067726955L;
	
	/**
	 * 
	 */
	private int idCategoria = 0;
	private String nome = "";
	private Date dataHora = new Date();

	public Categoria() {
		//
	}

	public int getIdCategoria() {
		return idCategoria;
	}
	
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;	
	}
	
	public String getNome() {
	    return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataHora() {
	    return dataHora;
	}
	
	public void setDataHora( Date dataHora ) {
		this.dataHora = dataHora;
	}

/*

import java.io.Serializable;

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Acao))
			return false;
		Acao other = (Acao) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		return true;
	}

	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.getClass().getSimpleName());
		buffer.append("{ ");
		buffer.append("id=").append(this.getId()).append("; ");
		buffer.append("descricao=").append(this.getDescricao()).append("; ");
		buffer.append("}");
		return buffer.toString();
	}	
*/
}
