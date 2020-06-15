package br.com.alura.exception;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.ApplicationException;

/*
 * Qual exception podemos gerar para acionar o rollback via EJB dentro do método salvar?
 * - RuntimeException é uma unchecked exception e toda unchecked exception causa rollback por padrão, mas cuidado, já que RuntimeException também significa usar uma SystemException.
 * 
 * */

//@ApplicationException(rollback=true) + extends Exception -> feito na mao para gerar roolback de uma checked (CHECKED)
//@ApplicationException(rollback=false) -> para Unchecked RuntimeExcpetion, nao precisa dessa declaracao. mas para nao gerar rollback de uma unchecked deve ser forcado dessa rollback=false:
@ApplicationException(rollback=false)
public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<String> mensagens;

	public BusinessException() {
		super();
		mensagens = new ArrayList<>();
	}

	public BusinessException(String mensagem) {
		super(mensagem);

		mensagens = new ArrayList<>();
		mensagens.add(mensagem);
	}

	public List<String> getMensagens() {
		return mensagens;
	}

	public void addMensagen(String mensagem) {
		this.mensagens.add(mensagem);
	}

}
